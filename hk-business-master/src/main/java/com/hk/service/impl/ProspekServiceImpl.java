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

import com.hk.dao.ProspekContactDao;
import com.hk.dao.ProspekDao;
import com.hk.dao.SalesDao;
import com.hk.dao.custom.ProspekContactDaoCustom;
import com.hk.entities.Prospek;
import com.hk.entities.ProspekContact;
import com.hk.service.ProspekService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.ProspekContactVO;
import com.hk.vo.ProspekVO;

@Service("prospekService")
public class ProspekServiceImpl implements ProspekService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("ProspekService : ");

	@Autowired
	private ProspekDao prospekDao;
	
	@Autowired
	private ProspekContactDao prospekContactDao;
	
	@Autowired
	private ProspekContactDaoCustom prospekContactDaoCustom;
	
	@Autowired
	private SalesDao salesDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveProspek(ProspekVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save prospek execute");
		Prospek model=modelMapper.map(p, Prospek.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getSalesId())){
			model.setSales(salesDao.findById(model.getSalesId()));
		}
		
		List<ProspekContact> tmpListProspekContact = new ArrayList<>();
		int counter = 1;
		for(ProspekContact prospekContact : model.getListProspekContact()){
			prospekContact.setId(model.getId()+"-"+counter);
			prospekContact.setCreateDate(DateUtil.now());
			prospekContact.setCreateBy(userService.getUser().getId());
			prospekContact.setIsActive(true);
			prospekContact.setProspek(model);
			prospekContact.setIndexCount(counter);
			tmpListProspekContact.add(prospekContact);
			counter++;
		}
		
		model.getListProspekContact().clear();
		model.getListProspekContact().addAll(tmpListProspekContact);
		
		Prospek prospek=prospekDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", prospek.getId());
		result.put("isActive", prospek.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllProspek() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listProspek", prospekDao.findAllProspek());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Prospek prospek=prospekDao.findById(id);
		result.put("prospek", prospek);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteProspek(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		prospekDao.delete(id);
		result.put("id", id);
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveProspekContact(ProspekContactVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save prospek execute");
		ProspekContact model=modelMapper.map(p, ProspekContact.class);
		
		model.setIndexCount(getIndexCount(model.getProspekId()));
		model.setId(model.getProspekId()+"-"+model.getIndexCount());
		
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getProspekId())){
			model.setProspek(prospekDao.findById(model.getProspekId()));
		}
		
		ProspekContact prospekContact=prospekContactDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", prospekContact.getId());
		result.put("isActive", prospekContact.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findDetailByParent(String Id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listProspekContact", prospekContactDao.findByProspekId(Id));
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findDetailById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		ProspekContact prospekContact=prospekContactDao.findById(id);
		result.put("prospekContact", prospekContact);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteProspekContact(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		prospekContactDao.delete(id);
		result.put("id", id);
		return result;
	}
	
	public Integer getIndexCount(String prospekId){
		Integer lastIndexCount = prospekContactDaoCustom.getLastIndexCount(prospekId);
		lastIndexCount++;
		return lastIndexCount;
	}
}
