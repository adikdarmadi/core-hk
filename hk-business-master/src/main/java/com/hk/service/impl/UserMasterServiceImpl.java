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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.GudangDao;
import com.hk.dao.KasBankDao;
import com.hk.dao.PegawaiDao;
import com.hk.dao.RoleDao;
import com.hk.dao.UserDao;
import com.hk.entities.User;
import com.hk.entities.UserGudang;
import com.hk.entities.UserKasBank;
import com.hk.entities.UserRole;
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
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveUser(UserVO p) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save user execute");
		User model=modelMapper.map(p, User.class);
		model.setId(model.getId().toUpperCase());
		
		PasswordUtil passwordUtil = new PasswordUtil();
		model.setPassword(passwordUtil.encryptPassword(p.getPassword()));
		
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getPegawaiId())){
			model.setPegawai(pegawaiDao.findById(model.getPegawaiId()));
		}
		
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
		
		User user=userDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", user.getId());
		result.put("isActive", user.getIsActive());
		return result;
	}
	
	@Override
	public Map<String,Object> findAllUser() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listUser", userDao.findAllUser());
		return result;
	}
	
	@Override
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		User user=userDao.findById(id);
		user.setPassword(null);
		result.put("user", user);
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
	
}
