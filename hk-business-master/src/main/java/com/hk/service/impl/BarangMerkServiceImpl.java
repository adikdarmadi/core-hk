package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.BarangMerkDao;
import com.hk.entities.AkunGrup;
import com.hk.entities.BarangMerk;
import com.hk.entities.Widget;
import com.hk.service.BarangMerkService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;
import com.hk.vo.BarangMerkVO;

@Service("barangMerkService")
public class BarangMerkServiceImpl implements BarangMerkService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("BarangMerkService : ");

	@Autowired
	private BarangMerkDao barangMerkDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveBarangMerk(BarangMerkVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangMerk execute");
		BarangMerk model=modelMapper.map(p, BarangMerk.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		BarangMerk barangMerk=barangMerkDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangMerk.getId());
		result.put("isActive", barangMerk.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editBarangMerk(BarangMerkVO p, Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangMerk execute");
		BarangMerk model=modelMapper.map(p, BarangMerk.class);

		BarangMerk obj = barangMerkDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		BarangMerk barangMerk=barangMerkDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangMerk.getId());
		result.put("isActive", barangMerk.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveBarangMerk(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangMerk execute");
		
		BarangMerk model = barangMerkDao.findById(id);
		
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
		
		BarangMerk barangMerk=barangMerkDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangMerk.getId());
		result.put("isActive", barangMerk.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllBarangMerk() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listBarangMerk", barangMerkDao.findAllBarangMerk());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		BarangMerk barangMerk=barangMerkDao.findById(id);
		result.put("barangMerk", barangMerk);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteBarangMerk(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		barangMerkDao.delete(id);
		result.put("id", id);
		return result;
	}


}
