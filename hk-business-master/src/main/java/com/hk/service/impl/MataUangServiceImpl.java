package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.MataUangDao;
import com.hk.entities.AkunGrup;
import com.hk.entities.MataUang;
import com.hk.service.MataUangService;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;
import com.hk.vo.MataUangVO;

@Service("mataUangService")
public class MataUangServiceImpl implements MataUangService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("MataUangService : ");

	@Autowired
	private MataUangDao mataUangDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveMataUang(MataUangVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save mataUang execute");
		MataUang model=modelMapper.map(p, MataUang.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		MataUang mataUang=mataUangDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", mataUang.getId());
		result.put("isActive", mataUang.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editMataUang(MataUangVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save mataUang execute");
		MataUang model=modelMapper.map(p, MataUang.class);

		MataUang obj = mataUangDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		MataUang mataUang=mataUangDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", mataUang.getId());
		result.put("isActive", mataUang.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllMataUang() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listMataUang", mataUangDao.findAllMataUang());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		MataUang mataUang=mataUangDao.findById(id);
		result.put("mataUang", mataUang);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteMataUang(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		mataUangDao.delete(id);
		result.put("id", id);
		return result;
	}


}
