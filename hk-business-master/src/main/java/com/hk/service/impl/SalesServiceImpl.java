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

import com.hk.dao.SalesDao;
import com.hk.dao.UserDao;
import com.hk.entities.AkunGrup;
import com.hk.entities.Sales;
import com.hk.entities.Widget;
import com.hk.service.SalesService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.SalesVO;

@Service("salesService")
public class SalesServiceImpl implements SalesService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("SalesService : ");

	@Autowired
	private SalesDao salesDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveSales(SalesVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save sales execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Sales model=modelMapper.map(p, Sales.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getUserId())){
			model.setUser(userDao.findById(model.getUserId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getSalesParentId())){
			model.setSalesParent(salesDao.findById(model.getSalesParentId()));
		}
		
		Sales sales=salesDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", sales.getId());
		result.put("isActive", sales.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editSales(SalesVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save sales execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Sales model=modelMapper.map(p, Sales.class);

		Sales obj = salesDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		if(CommonUtil.isNotNullOrEmpty(model.getUserId())){
			model.setUser(userDao.findById(model.getUserId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getSalesParentId())){
			model.setSalesParent(salesDao.findById(model.getSalesParentId()));
		}
		
		Sales sales=salesDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", sales.getId());
		result.put("isActive", sales.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveSales(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save sales execute");
		
		Sales model = salesDao.findById(id);
		
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
		
		Sales sales=salesDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", sales.getId());
		result.put("isActive", sales.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllSales() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listSales", salesDao.findAllSales());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Sales sales=salesDao.findById(id);
		result.put("sales", sales);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteSales(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		salesDao.delete(id);
		result.put("id", id);
		return result;
	}


}
