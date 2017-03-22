package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.ModuleDao;
import com.hk.entities.Module;
import com.hk.service.ModuleService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.ModuleVO;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("ModuleService : ");

	@Autowired
	private ModuleDao moduleDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveModule(ModuleVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save module execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Module model=modelMapper.map(p, Module.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getModuleParentId())){
			model.setModuleParent(moduleDao.findById(model.getModuleParentId()));
		}
		
		Module module=moduleDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", module.getId());
		result.put("isActive", module.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editModule(ModuleVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save module execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Module model=modelMapper.map(p, Module.class);

		Module obj = moduleDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		if(CommonUtil.isNotNullOrEmpty(model.getModuleParentId())){
			model.setModuleParent(moduleDao.findById(model.getModuleParentId()));
		}
		
		Module module=moduleDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", module.getId());
		result.put("isActive", module.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveModule(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save module execute");
		
		Module model = moduleDao.findById(id);
		
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
		
		Module module=moduleDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", module.getId());
		result.put("isActive", module.getIsActive());
		return result;
	}
	
	@Override
	public Map<String,Object> findAllModule() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listModule", moduleDao.findAllModule());
		return result;
	}
	
	@Override
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Module module=moduleDao.findById(id);
		result.put("module", module);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteModule(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		moduleDao.delete(id);
		result.put("id", id);
		return result;
	}
	
	@Override
	public Map<String,Object> findParent() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listModule", moduleDao.findParent());
		return result;
	}

}
