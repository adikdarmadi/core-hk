package com.hk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.AkunDao;
import com.hk.dao.AkunGrupDao;
import com.hk.entities.Akun;
import com.hk.entities.AkunGrup;
import com.hk.service.AkunService;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.AkunVO;

@Service("akunService")
public class AkunServiceImpl implements AkunService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("AkunService : ");

	@Autowired
	private AkunDao akunDao;
	
	@Autowired
	private AkunGrupDao akunGrupDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveAkun(AkunVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save akun execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Akun model=modelMapper.map(p, Akun.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		if(CommonUtil.isNotNullOrEmpty(model.getAkunGrupId())){
			model.setAkunGrup(akunGrupDao.findById(model.getAkunGrupId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getAkunParentId())){
			model.setAkunParent(akunDao.findById(model.getAkunParentId()));
		}
		Akun akun=akunDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", akun.getId());
		result.put("isActive", akun.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editAkun(AkunVO p,Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save akun execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Akun model=modelMapper.map(p, Akun.class);
		
		Akun obj = akunDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		if(CommonUtil.isNotNullOrEmpty(model.getAkunGrupId())){
			model.setAkunGrup(akunGrupDao.findById(model.getAkunGrupId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getAkunParentId())){
			model.setAkunParent(akunDao.findById(model.getAkunParentId()));
		}
		
		Akun akun=akunDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", akun.getId());
		result.put("isActive", akun.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveAkun(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save akun execute");
		
		Akun model = akunDao.findById(id);
		
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
		
		Akun akun=akunDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", akun.getId());
		result.put("isActive", akun.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllAkun(Map<String, String> pathVariables) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		
		List<Object> listMap = new ArrayList<Object>();
		for(Map<String, Object> map : akunDao.findAllAkun()){
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
		result.put("listAkun", listMap);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Akun akun=akunDao.findById(id);
		result.put("akun", akun);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteAkun(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		akunDao.delete(id);
		result.put("id", id);
		return result;
	}


}
