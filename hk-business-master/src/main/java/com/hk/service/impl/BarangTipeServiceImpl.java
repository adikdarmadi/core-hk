package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.BarangTipeDao;
import com.hk.entities.BarangTipe;
import com.hk.service.BarangTipeService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;
import com.hk.vo.BarangTipeVO;

@Service("barangTipeService")
public class BarangTipeServiceImpl implements BarangTipeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("BarangTipeService : ");

	@Autowired
	private BarangTipeDao barangTipeDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveBarangTipe(BarangTipeVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangTipe execute");
		BarangTipe model=modelMapper.map(p, BarangTipe.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		BarangTipe barangTipe=barangTipeDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangTipe.getId());
		result.put("isActive", barangTipe.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editBarangTipe(BarangTipeVO p, Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangTipe execute");
		BarangTipe model=modelMapper.map(p, BarangTipe.class);

		BarangTipe obj = barangTipeDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		BarangTipe barangTipe=barangTipeDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangTipe.getId());
		result.put("isActive", barangTipe.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveBarangTipe(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangTipe execute");
		
		BarangTipe model = barangTipeDao.findById(id);
		
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
		
		BarangTipe barangTipe=barangTipeDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangTipe.getId());
		result.put("isActive", barangTipe.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllBarangTipe() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listBarangTipe", barangTipeDao.findAllBarangTipe());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		BarangTipe barangTipe=barangTipeDao.findById(id);
		result.put("barangTipe", barangTipe);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteBarangTipe(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		barangTipeDao.delete(id);
		result.put("id", id);
		return result;
	}


}
