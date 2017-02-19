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
import com.hk.entities.MataUang;
import com.hk.service.MataUangService;
import com.hk.service.UserService;
import com.hk.util.HibernateInitialize;
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
	
	


}
