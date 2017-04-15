package com.hk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.GudangGrupDao;
import com.hk.dao.custom.LoggingJdbcDao;
import com.hk.entities.AkunGrup;
import com.hk.entities.GudangGrup;
import com.hk.entities.Widget;
import com.hk.entitiesAuditLog.AuditLog;
import com.hk.enumeration.ActionEnum;
import com.hk.service.GudangGrupService;
import com.hk.service.LoggingService;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;
import com.hk.vo.GudangGrupVO;

@Service("gudangGrupService")
public class GudangGrupServiceImpl implements GudangGrupService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("GudangGrupService : ");

	@Autowired
	private GudangGrupDao gudangGrupDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoggingService loggingService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly = false)
	public Map<String,Object> saveGudangGrup(GudangGrupVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save gudangGrup execute");
		GudangGrup model=modelMapper.map(p, GudangGrup.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		GudangGrup gudangGrup=gudangGrupDao.save(model);
		//loggingService.insertAuditLog(ActionEnum.Saved.getVal(), model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", gudangGrup.getId());
		result.put("isActive", gudangGrup.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editGudangGrup(GudangGrupVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save gudangGrup execute");
		GudangGrup model=modelMapper.map(p, GudangGrup.class);

		GudangGrup obj = gudangGrupDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		GudangGrup gudangGrup=gudangGrupDao.save(model);
		//loggingService.insertAuditLog(ActionEnum.Updated.getVal(), model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", gudangGrup.getId());
		result.put("isActive", gudangGrup.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveGudangGrup(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save gudangGrup execute");
		
		GudangGrup model = gudangGrupDao.findById(id);
		
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
		
		GudangGrup gudangGrup=gudangGrupDao.save(model);
		/*if(model.getIsActive()){
			loggingService.insertAuditLog(ActionEnum.Actived.getVal(), model);
		}else{
			loggingService.insertAuditLog(ActionEnum.NonActived.getVal(), model);
		}*/
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", gudangGrup.getId());
		result.put("isActive", gudangGrup.getIsActive());
		return result;
	}
	
	@Override
	public Map<String,Object> findAllGudangGrup(Map<String, String> pathVariables) {
		Map<String,Object> result=new HashMap<String,Object>(); 

		List<Object> listMap = new ArrayList<Object>();
		for(Map<String, Object> map : gudangGrupDao.findAllGudangGrup()){
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
		
		result.put("listGudangGrup", listMap);
		return result;
	}
	
	@Override
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		GudangGrup gudangGrup=gudangGrupDao.findById(id);
		result.put("gudangGrup", gudangGrup);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteGudangGrup(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		gudangGrupDao.delete(id);
		result.put("id", id);
		return result;
	}


}
