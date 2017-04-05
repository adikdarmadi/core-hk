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

import com.hk.dao.UnitDao;
import com.hk.entities.AkunGrup;
import com.hk.entities.Unit;
import com.hk.entities.Widget;
import com.hk.service.UnitService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;
import com.hk.vo.UnitVO;

@Service("unitService")
public class UnitServiceImpl implements UnitService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("UnitService : ");

	@Autowired
	private UnitDao unitDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveUnit(UnitVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save unit execute");
		Unit model=modelMapper.map(p, Unit.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		Unit unit=unitDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", unit.getId());
		result.put("isActive", unit.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editUnit(UnitVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save unit execute");
		Unit model=modelMapper.map(p, Unit.class);

		Unit obj = unitDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		Unit unit=unitDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", unit.getId());
		result.put("isActive", unit.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveUnit(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save unit execute");
		
		Unit model = unitDao.findById(id);
		
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
		
		Unit unit=unitDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", unit.getId());
		result.put("isActive", unit.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllUnit(Map<String, String> pathVariables) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		
		List<Object> listMap = new ArrayList<Object>();
		for(Map<String, Object> map : unitDao.findAllUnit()){
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
		
		result.put("listUnit", listMap);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Unit unit=unitDao.findById(id);
		result.put("unit", unit);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteUnit(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		unitDao.delete(id);
		result.put("id", id);
		return result;
	}


}
