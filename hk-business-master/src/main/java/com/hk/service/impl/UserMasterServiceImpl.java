package com.hk.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hk.dao.GudangDao;
import com.hk.dao.KasBankDao;
import com.hk.dao.PegawaiDao;
import com.hk.dao.RoleDao;
import com.hk.dao.UserDao;
import com.hk.dao.UserGudangDao;
import com.hk.dao.UserKasBankDao;
import com.hk.dao.UserRoleDao;
import com.hk.dao.custom.UserGudangDaoCustom;
import com.hk.dao.custom.UserKasBankDaoCustom;
import com.hk.dao.custom.UserRoleDaoCustom;
import com.hk.entities.AkunGrup;
import com.hk.entities.Gudang;
import com.hk.entities.KasBank;
import com.hk.entities.Role;
import com.hk.entities.User;
import com.hk.entities.UserGudang;
import com.hk.entities.UserKasBank;
import com.hk.entities.UserRole;
import com.hk.entities.Widget;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.util.PasswordUtil;
import com.hk.vo.UserVO;

/**
 * Implement class for UserService
 * 
 * @author Adhityarismawan
 */
@Service("UserMasterService")
public class UserMasterServiceImpl implements UserMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PegawaiDao pegawaiDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private KasBankDao kasBankDao;
	
	@Autowired
	private GudangDao gudangDao;
	
	@Autowired
	private UserGudangDaoCustom userGudangDaoCustom;
	
	@Autowired
	private UserRoleDaoCustom userRoleDaoCustom;
	
	@Autowired
	private UserKasBankDaoCustom userKasBankDaoCustom;
	
	@Autowired
	private UserGudangDao userGudangDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private UserKasBankDao userKasBankDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveUser(UserVO p) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save user execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User model=modelMapper.map(p, User.class);
		model.setId(model.getId());
		
		PasswordUtil passwordUtil = new PasswordUtil();
		model.setPassword(passwordUtil.encryptPassword(p.getId()));
		
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getPegawaiId())){
			model.setPegawai(pegawaiDao.findById(model.getPegawaiId()));
		}
		
		if(p.getRoles() != null){
			List<UserRole> listUserRole = new ArrayList<UserRole>();
		
			for(String role : p.getRoles()){
				UserRole userRole=new UserRole();
				if(CommonUtil.isNotNullOrEmpty(role)){
					userRole.setRole(roleDao.findById(role));
					userRole.setUser(model);
					listUserRole.add(userRole);
				}
			}
			
			model.getListUserRole().clear();
			model.setListUserRole(listUserRole);
		}
		
		if(p.getGudangs() != null){
			List<UserGudang> listUserGudang = new ArrayList<UserGudang>();
			
			for(String gudang : p.getGudangs()){
				UserGudang userGudang=new UserGudang();
				if(CommonUtil.isNotNullOrEmpty(gudang)){
					userGudang.setGudang(gudangDao.findById(gudang));
					userGudang.setUser(model);
					listUserGudang.add(userGudang);
				}
			}
			
			model.getListUserGudang().clear();
			model.setListUserGudang(listUserGudang);
		}
		
		if(p.getKasBanks() != null){
			List<UserKasBank> listUserKasBank = new ArrayList<UserKasBank>();
			
			for(String kasBank : p.getKasBanks()){
				UserKasBank userKasBank=new UserKasBank();
				if(CommonUtil.isNotNullOrEmpty(kasBank)){
					userKasBank.setKasBank(kasBankDao.findById(kasBank));
					userKasBank.setUser(model);
					listUserKasBank.add(userKasBank);
				}
			}
			
			model.getListUserKasBank().clear();
			model.setListUserKasBank(listUserKasBank);
		}
		
		User user=userDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", user.getId());
		result.put("isActive", user.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editUser(UserVO p, Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save user execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User model=modelMapper.map(p, User.class);
		
		User obj = userDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setPassword(obj.getPassword());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		if(CommonUtil.isNotNullOrEmpty(model.getPegawaiId())){
			model.setPegawai(pegawaiDao.findById(model.getPegawaiId()));
		}
		
		if(p.getRoles() != null){
			List<UserRole> listUserRole = new ArrayList<UserRole>();
			
			for(String role : p.getRoles()){
				UserRole userRole=new UserRole();
				if(CommonUtil.isNotNullOrEmpty(role)){
					userRole.setRole(roleDao.findById(role));
					userRole.setUser(model);
					listUserRole.add(userRole);
				}
			}
			
			userRoleDaoCustom.deleteByUserId(model.getId());
			model.getListUserRole().clear();
			model.setListUserRole(listUserRole);
		}
	
		if(p.getGudangs() != null){
			List<UserGudang> listUserGudang = new ArrayList<UserGudang>();
			
			for(String gudang : p.getGudangs()){
				UserGudang userGudang=new UserGudang();
				if(CommonUtil.isNotNullOrEmpty(gudang)){
					userGudang.setGudang(gudangDao.findById(gudang));
					userGudang.setUser(model);
					listUserGudang.add(userGudang);
				}
			}
			
			userGudangDaoCustom.deleteByUserId(model.getId());
			model.getListUserGudang().clear();
			model.setListUserGudang(listUserGudang);
		}
		
		if(p.getKasBanks() != null){
			List<UserKasBank> listUserKasBank = new ArrayList<UserKasBank>();
			
			for(String kasBank : p.getKasBanks()){
				UserKasBank userKasBank=new UserKasBank();
				if(CommonUtil.isNotNullOrEmpty(kasBank)){
					userKasBank.setKasBank(kasBankDao.findById(kasBank));
					userKasBank.setUser(model);
					listUserKasBank.add(userKasBank);
				}
			}
			
			userKasBankDaoCustom.deleteByUserId(model.getId());
			model.getListUserKasBank().clear();
			model.setListUserKasBank(listUserKasBank);
		}
		
		User user=userDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", user.getId());
		result.put("isActive", user.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveUser(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save user execute");
		
		User model = userDao.findById(id);
		
		if(model.getIsActive()){
			model.setIsActive(false);
			model.setDateNonActive(DateUtil.now());
		}else{
			model.setIsActive(true);
			model.setDateNonActive(null);
		}
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		User user=userDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", user.getId());
		result.put("isActive", user.getIsActive());
		return result;
	}
	
	@Override
	public Map<String,Object> findAllUser(Map<String, String> pathVariables) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		
		List<Object> listMap = new ArrayList<Object>();
		
		for(Map<String, Object> map : userDao.findAllUser()){
			int notAdd = 0;
			
			map.put("gudangs", userGudangDao.findGudangByUserId(map.get("id").toString()));
			map.put("roles", userRoleDao.findRoleByUserId(map.get("id").toString()));
			map.put("kasBanks", userKasBankDao.findKasBankByUserId(map.get("id").toString()));
			
			for(Map.Entry<String, String> filter : pathVariables.entrySet()){
				if(!filter.getValue().equalsIgnoreCase("all")){
					if(!filter.getValue().equalsIgnoreCase(map.get(filter.getKey()).toString())){
						notAdd++;
					}
				}
			}
			
			if(notAdd == 0){
				listMap.add(map);
			}
			
		}
		result.put("listUser", listMap);
		return result;
	}
	
	@Override
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		User user=userDao.findById(id);
		
		Map<String, Object> map = objectMapper.convertValue(user, Map.class);
		map.remove("password");
		
		map.put("gudangs", userGudangDao.findGudangByUserId(id));
		map.put("roles", userRoleDao.findRoleByUserId(id));
		map.put("kasBanks", userKasBankDao.findKasBankByUserId(id));
		
		result.put("user", map);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteUser(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		userDao.delete(id);
		result.put("id", id);
		return result;
	}
	
	@Override
	public Map<String,Object> findGudangCheckByUserId(String userId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		List<Object> listMap = new ArrayList<Object>();
		for(Gudang gudang : gudangDao.findByIsActive(true)){
			Map<String,Object> map=new HashMap<String,Object>(); 
			map.put("id", gudang.getId());
			map.put("nama", gudang.getNama());
			if(CommonUtil.isNotNullOrEmpty(userGudangDao.findByUserIdGudangId(userId, gudang.getId()))){
				map.put("isSelected", true);
			}else{
				map.put("isSelected", false);
			}
			listMap.add(map);
		}
		result.put("listGudang", listMap);
		return result;
	}
	
	@Override
	public Map<String,Object> findRoleCheckByUserId(String userId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		List<Object> listMap = new ArrayList<Object>();
		for(Role role : roleDao.findByIsActive(true)){
			Map<String,Object> map=new HashMap<String,Object>(); 
			map.put("id", role.getId());
			map.put("nama", role.getNama());
			if(CommonUtil.isNotNullOrEmpty(userRoleDao.findByUserIdRoleId(userId, role.getId()))){
				map.put("isSelected", true);
			}else{
				map.put("isSelected", false);
			}
			listMap.add(map);
		}
		result.put("listRole", listMap);
		return result;
	}
	
	@Override
	public Map<String,Object> findKasBankCheckByUserId(String userId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		List<Object> listMap = new ArrayList<Object>();
		for(KasBank kasBank : kasBankDao.findByIsActive(true)){
			Map<String,Object> map=new HashMap<String,Object>(); 
			map.put("id", kasBank.getId());
			map.put("deskripsi", kasBank.getDeskripsi());
			if(CommonUtil.isNotNullOrEmpty(userKasBankDao.findByUserIdKasBankId(userId, kasBank.getId()))){
				map.put("isSelected", true);
			}else{
				map.put("isSelected", false);
			}
			listMap.add(map);
		}
		result.put("listKasBank", listMap);
		return result;
	}
	
	@Override
	public Map<String,Object> findByGudangId(String gudangId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listGudang", userGudangDao.findUserByGudangId(gudangId));
		return result;
	}
	
	@Override
	public Map<String,Object> findByRoleId(String roleId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listRole", userRoleDao.findUserByRoleId(roleId));
		return result;
	}
	
	@Override
	public Map<String,Object> findByKasBankId(String kasBankId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listKasBank", userKasBankDao.findUserByKasBankId(kasBankId));
		return result;
	}
	

	@Override
	public Map<String,Object> findvUser(){
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listvUser", userDao.findvUser());
		return result;
	}
}
