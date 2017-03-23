package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.AkunGrupDao;
import com.hk.entities.AkunGrup;
import com.hk.service.AkunGrupService;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;
import com.hk.vo.AkunGrupVO;

@Service("akunGrupService")
public class AkunGrupServiceImpl implements AkunGrupService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("AkunGrupService : ");

	@Autowired
	private AkunGrupDao akunGrupDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveAkunGrup(AkunGrupVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save akunGrup execute");
		AkunGrup model=modelMapper.map(p, AkunGrup.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		AkunGrup akunGrup=akunGrupDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", akunGrup.getId());
		result.put("isActive", akunGrup.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editAkunGrup(AkunGrupVO p,Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save akunGrup execute");
		AkunGrup model=modelMapper.map(p, AkunGrup.class);
		
		AkunGrup obj = akunGrupDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		AkunGrup akunGrup=akunGrupDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", akunGrup.getId());
		result.put("isActive", akunGrup.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveAkunGrup(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save akunGrup execute");
		
		AkunGrup model = akunGrupDao.findById(id);
		
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
		
		AkunGrup akunGrup=akunGrupDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", akunGrup.getId());
		result.put("isActive", akunGrup.getIsActive());
		return result;
	}
	
	@Override
	public Map<String,Object> findAllAkunGrup() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listAkunGrup", akunGrupDao.findAllAkunGrup());
		return result;
	}
	
	@Override
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		AkunGrup akunGrup=akunGrupDao.findById(id);
		result.put("akunGrup", akunGrup);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteAkunGrup(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		akunGrupDao.delete(id);
		result.put("id", id);
		return result;
	}


}
