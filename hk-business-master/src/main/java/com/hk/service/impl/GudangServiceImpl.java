package com.hk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.GudangDao;
import com.hk.dao.GudangGrupDao;
import com.hk.dao.UserDao;
import com.hk.dao.UserGudangDao;
import com.hk.dao.custom.UserGudangDaoCustom;
import com.hk.entities.AkunGrup;
import com.hk.entities.Gudang;
import com.hk.entities.UserGudang;
import com.hk.entities.Widget;
import com.hk.service.GudangService;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.GudangVO;

@Service("gudangService")
public class GudangServiceImpl implements GudangService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("GudangService : ");

	@Autowired
	private GudangDao gudangDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserGudangDao userGudangDao;
	
	@Autowired
	private UserGudangDaoCustom userGudangDaoCustom;
	
	@Autowired
	private GudangGrupDao gudangGrupDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveGudang(GudangVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save gudang execute");
		Gudang model=modelMapper.map(p, Gudang.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		model.setTglAwalStock(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglAwalStock())));

		if (CommonUtil.isNotNullOrEmpty(model.getGudangGrupId())) {
			model.setGudangGrup(gudangGrupDao.findById(model.getGudangGrupId()));
		}
		
		List<UserGudang> listUserGudang = new ArrayList<UserGudang>();
		for(String user : p.getUsers()){
			UserGudang userGudang=new UserGudang();
			if(CommonUtil.isNotNullOrEmpty(user)){
				userGudang.setUser(userDao.findById(user));
				userGudang.setGudang(model);
				listUserGudang.add(userGudang);
			}
		}
		
		model.getListUserGudang().clear();
		model.setListUserGudang(listUserGudang);
		
		Gudang gudang=gudangDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", gudang.getId());
		result.put("isActive", gudang.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editGudang(GudangVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save gudang execute");
		Gudang model=modelMapper.map(p, Gudang.class);

		Gudang obj = gudangDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		model.setTglAwalStock(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglAwalStock())));

		if (CommonUtil.isNotNullOrEmpty(model.getGudangGrupId())) {
			model.setGudangGrup(gudangGrupDao.findById(model.getGudangGrupId()));
		}
		
		List<UserGudang> listUserGudang = new ArrayList<UserGudang>();
		for(String user : p.getUsers()){
			UserGudang userGudang=new UserGudang();
			if(CommonUtil.isNotNullOrEmpty(user)){
				userGudang.setUser(userDao.findById(user));
				userGudang.setGudang(model);
				listUserGudang.add(userGudang);
			}
		}
		
		userGudangDaoCustom.deleteByGudangId(model.getId());
		model.getListUserGudang().clear();
		model.setListUserGudang(listUserGudang);
		
		Gudang gudang=gudangDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", gudang.getId());
		result.put("isActive", gudang.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveGudang(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save gudang execute");
		
		Gudang model = gudangDao.findById(id);
		
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
		
		Gudang gudang=gudangDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", gudang.getId());
		result.put("isActive", gudang.getIsActive());
		return result;
	}
	
	@Override
	public Map<String,Object> findAllGudang() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listGudang", gudangDao.findAllGudang());
		return result;
	}
	
	@Override
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Gudang gudang=gudangDao.findById(id);
		result.put("gudang", gudang);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteGudang(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		gudangDao.delete(id);
		result.put("id", id);
		return result;
	}

	@Override
	public Map<String,Object> findByUserId(String userId){
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listGudang", userGudangDao.findGudangByUserId(userId));
		return result;
	}
}
