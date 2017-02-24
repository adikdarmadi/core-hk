package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.BarangDivisiDao;
import com.hk.entities.BarangDivisi;
import com.hk.service.BarangDivisiService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;
import com.hk.vo.BarangDivisiVO;

@Service("barangDivisiService")
public class BarangDivisiServiceImpl implements BarangDivisiService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("BarangDivisiService : ");

	@Autowired
	private BarangDivisiDao barangDivisiDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveBarangDivisi(BarangDivisiVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangDivisi execute");
		BarangDivisi model=modelMapper.map(p, BarangDivisi.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		BarangDivisi barangDivisi=barangDivisiDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangDivisi.getId());
		result.put("isActive", barangDivisi.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllBarangDivisi() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listBarangDivisi", barangDivisiDao.findAllBarangDivisi());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		BarangDivisi barangDivisi=barangDivisiDao.findById(id);
		result.put("barangDivisi", barangDivisi);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteBarangDivisi(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		barangDivisiDao.delete(id);
		result.put("id", id);
		return result;
	}


}
