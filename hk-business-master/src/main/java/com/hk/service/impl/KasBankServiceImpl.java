package com.hk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.AkunDao;
import com.hk.dao.KasBankDao;
import com.hk.dao.MataUangDao;
import com.hk.dao.UserDao;
import com.hk.dao.UserKasBankDao;
import com.hk.dao.custom.UserKasBankDaoCustom;
import com.hk.entities.AkunGrup;
import com.hk.entities.KasBank;
import com.hk.entities.User;
import com.hk.entities.UserGudang;
import com.hk.entities.UserKasBank;
import com.hk.entities.Widget;
import com.hk.service.KasBankService;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.KasBankVO;


@Service("kasBankService")
public class KasBankServiceImpl implements KasBankService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("KasBankService : ");

	@Autowired
	private KasBankDao kasBankDao;
	
	@Autowired
	private UserKasBankDao userKasBankDao;
	
	@Autowired
	private UserKasBankDaoCustom userKasBankDaoCustom;
	
	@Autowired
	private AkunDao akunDao;
	
	@Autowired
	private MataUangDao mataUangDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveKasBank(KasBankVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save kasBank execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		KasBank model=modelMapper.map(p, KasBank.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getTanggalRegistrasi())){
			model.setTanggalRegistrasi(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTanggalRegistrasi())));
		}

		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getMataUangId())){
			model.setMataUang(mataUangDao.findById(model.getMataUangId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getKurs()) && CommonUtil.isNotNullOrEmpty(model.getSaldoAwal())){
			model.setSaldoAwalRp(model.getSaldoAwal().multiply(model.getKurs()));
		}
		
		if(p.getUsers() != null){
			List<UserKasBank> listUserKasBank = new ArrayList<UserKasBank>();
			
			for(String user : p.getUsers()){
				UserKasBank userKasBank=new UserKasBank();
				if(CommonUtil.isNotNullOrEmpty(user)){
					userKasBank.setUser(userDao.findById(user));
					userKasBank.setKasBank(model);
					listUserKasBank.add(userKasBank);
				}
			}
			
			model.getListUserKasBank().clear();
			model.setListUserKasBank(listUserKasBank);
		}
		
		KasBank kasBank=kasBankDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", kasBank.getId());
		result.put("isActive", kasBank.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editKasBank(KasBankVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save kasBank execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		KasBank model=modelMapper.map(p, KasBank.class);

		KasBank obj = kasBankDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		if(CommonUtil.isNotNullOrEmpty(model.getTanggalRegistrasi())){
			model.setTanggalRegistrasi(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTanggalRegistrasi())));
		}

		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getMataUangId())){
			model.setMataUang(mataUangDao.findById(model.getMataUangId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getKurs()) && CommonUtil.isNotNullOrEmpty(model.getSaldoAwal())){
			model.setSaldoAwalRp(model.getSaldoAwal().multiply(model.getKurs()));
		}
		
		if(p.getUsers() != null){
			List<UserKasBank> listUserKasBank = new ArrayList<UserKasBank>();
			for(String user : p.getUsers()){
				UserKasBank userKasBank=new UserKasBank();
				if(CommonUtil.isNotNullOrEmpty(user)){
					userKasBank.setUser(userDao.findById(user));
					userKasBank.setKasBank(model);
					listUserKasBank.add(userKasBank);
				}
			}
			
			userKasBankDaoCustom.deleteByKasBankId(model.getId());
			model.getListUserKasBank().clear();
			model.setListUserKasBank(listUserKasBank);
		}
		
		KasBank kasBank=kasBankDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", kasBank.getId());
		result.put("isActive", kasBank.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveKasBank(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save kasBank execute");
		
		KasBank model = kasBankDao.findById(id);
		
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
		
		KasBank kasBank=kasBankDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", kasBank.getId());
		result.put("isActive", kasBank.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllKasBank(Map<String, String> pathVariables) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		
		List<Object> listMap = new ArrayList<Object>();
		for(Map<String, Object> map : kasBankDao.findAllKasBank()){
			int notAdd = 0;
			
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
		
		result.put("listKasBank", listMap);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		KasBank kasBank=kasBankDao.findById(id);
		result.put("kasBank", kasBank);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteKasBank(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		kasBankDao.delete(id);
		result.put("id", id);
		return result;
	}

	@Override
	public Map<String,Object> findByUserId(String userId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listKasBank", userKasBankDao.findKasBankByUserId(userId));
		return result;
	}
	
	@Override
	public Map<String,Object> findUserCheckByKasBankId(String kasBankId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		List<Object> listMap = new ArrayList<Object>();
		for(User user : userDao.findByIsActive(true)){
			Map<String,Object> map=new HashMap<String,Object>(); 
			map.put("id", user.getId());
			map.put("nama", user.getNama());
			if(CommonUtil.isNotNullOrEmpty(userKasBankDao.findByUserIdKasBankId(user.getId(), kasBankId))){
				map.put("isSelected", true);
			}else{
				map.put("isSelected", false);
			}
			listMap.add(map);
		}
		result.put("listKasBank", listMap);
		return result;
	}
}
