package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.AkunDao;
import com.hk.dao.CostDao;
import com.hk.dao.MataUangDao;
import com.hk.entities.AkunGrup;
import com.hk.entities.Cost;
import com.hk.entities.Widget;
import com.hk.service.CostService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.CostVO;

@Service("costService")
public class CostServiceImpl implements CostService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("CostService : ");

	@Autowired
	private CostDao costDao;
	
	@Autowired
	private MataUangDao mataUangDao;
	
	@Autowired
	private AkunDao akunDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveCost(CostVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save cost execute");
		Cost model=modelMapper.map(p, Cost.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		model.setTglAwal(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglAwal())));
		if(CommonUtil.isNotNullOrEmpty(model.getMataUangId())){
			model.setMataUang(mataUangDao.findById(model.getMataUangId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		
		Cost cost=costDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", cost.getId());
		result.put("isActive", cost.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editCost(CostVO p, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save cost execute");
		Cost model=modelMapper.map(p, Cost.class);

		Cost obj = costDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		model.setTglAwal(DateUtil.toDate(DateUtil.defaultFormatDate(model.getTglAwal())));
		if(CommonUtil.isNotNullOrEmpty(model.getMataUangId())){
			model.setMataUang(mataUangDao.findById(model.getMataUangId()));
		}
		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		
		Cost cost=costDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", cost.getId());
		result.put("isActive", cost.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveCost(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save cost execute");
		
		Cost model = costDao.findById(id);
		
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
		
		Cost cost=costDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", cost.getId());
		result.put("isActive", cost.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllCost() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listCost", costDao.findAllCost());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Cost cost=costDao.findById(id);
		result.put("cost", cost);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteCost(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		costDao.delete(id);
		result.put("id", id);
		return result;
	}


}
