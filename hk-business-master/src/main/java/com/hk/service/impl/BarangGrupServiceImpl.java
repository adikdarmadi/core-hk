package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.BarangGrupDao;
import com.hk.entities.AkunGrup;
import com.hk.entities.BarangGrup;
import com.hk.entities.Widget;
import com.hk.service.BarangGrupService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;
import com.hk.vo.BarangGrupVO;

@Service("barangGrupService")
public class BarangGrupServiceImpl implements BarangGrupService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("BarangGrupService : ");

	@Autowired
	private BarangGrupDao barangGrupDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveBarangGrup(BarangGrupVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangGrup execute");
		BarangGrup model=modelMapper.map(p, BarangGrup.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		BarangGrup barangGrup=barangGrupDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangGrup.getId());
		result.put("isActive", barangGrup.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editBarangGrup(BarangGrupVO p,Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangGrup execute");
		BarangGrup model=modelMapper.map(p, BarangGrup.class);

		BarangGrup obj = barangGrupDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		BarangGrup barangGrup=barangGrupDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangGrup.getId());
		result.put("isActive", barangGrup.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveBarangGrup(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save barangGrup execute");
		
		BarangGrup model = barangGrupDao.findById(id);
		
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
		
		BarangGrup barangGrup=barangGrupDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", barangGrup.getId());
		result.put("isActive", barangGrup.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllBarangGrup() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listBarangGrup", barangGrupDao.findAllBarangGrup());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		BarangGrup barangGrup=barangGrupDao.findById(id);
		result.put("barangGrup", barangGrup);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteBarangGrup(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		barangGrupDao.delete(id);
		result.put("id", id);
		return result;
	}


}
