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

import com.hk.dao.DepartmentDtlDao;
import com.hk.dao.DepartmentHdrDao;
import com.hk.entities.DepartmentHdr;
import com.hk.entities.Widget;
import com.hk.entities.AkunGrup;
import com.hk.entities.DepartmentDtl;
import com.hk.service.DepartmentHdrService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.DepartmentDtlVO;
import com.hk.vo.DepartmentHdrVO;

@Service("departmentHdrService")
public class DepartmentHdrServiceImpl implements DepartmentHdrService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("DepartmentHdrService : ");

	@Autowired
	private DepartmentHdrDao departmentHdrDao;
	
	@Autowired
	private DepartmentDtlDao departmentDtlDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveDepartmentHdr(DepartmentHdrVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save departmentHdr execute");
		DepartmentHdr model=modelMapper.map(p, DepartmentHdr.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		List<DepartmentDtl> tmpListDepartmentDtl = new ArrayList<>();
		for(DepartmentDtl departmentDtl : model.getListDepartmentDtl()){
			departmentDtl.setCreateDate(DateUtil.now());
			departmentDtl.setCreateBy(userService.getUser().getId());
			departmentDtl.setIsActive(true);
			departmentDtl.setDepartmentHdr(model);
			tmpListDepartmentDtl.add(departmentDtl);
		}
		
		model.getListDepartmentDtl().clear();
		model.getListDepartmentDtl().addAll(tmpListDepartmentDtl);
		
		DepartmentHdr departmentHdr=departmentHdrDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", departmentHdr.getId());
		result.put("isActive", departmentHdr.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editDepartmentHdr(DepartmentHdrVO p, Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save departmentHdr execute");
		DepartmentHdr model=modelMapper.map(p, DepartmentHdr.class);

		DepartmentHdr obj = departmentHdrDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		DepartmentHdr departmentHdr=departmentHdrDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", departmentHdr.getId());
		result.put("isActive", departmentHdr.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllDepartmentHdr(Map<String, String> pathVariables) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		
		List<Object> listMap = new ArrayList<Object>();
		for(Map<String, Object> map : departmentHdrDao.findAllDepartmentHdr()){
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
		
		result.put("listDepartmentHdr", listMap);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		DepartmentHdr departmentHdr=departmentHdrDao.findById(id);
		result.put("departmentHdr", departmentHdr);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteDepartmentHdr(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		departmentHdrDao.delete(id);
		result.put("id", id);
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveDepartmentDtl(DepartmentDtlVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save departmentHdr execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		DepartmentDtl model=modelMapper.map(p, DepartmentDtl.class);
		
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getDepartmentHdrId())){
			model.setDepartmentHdr(departmentHdrDao.findById(model.getDepartmentHdrId()));
		}
		
		DepartmentDtl departmentDtl=departmentDtlDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", departmentDtl.getId());
		result.put("isActive", departmentDtl.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> editDepartmentDtl(DepartmentDtlVO p, Integer id, Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save departmentHdr execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		DepartmentDtl model=modelMapper.map(p, DepartmentDtl.class);
		
		DepartmentDtl obj = departmentDtlDao.findById(id);
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setDepartmentHdr(obj.getDepartmentHdr());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
		DepartmentDtl departmentDtl=departmentDtlDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", departmentDtl.getId());
		result.put("isActive", departmentDtl.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveDepartmentHdr(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save departmentHdr execute");
		
		DepartmentHdr model = departmentHdrDao.findById(id);
		
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
		
		DepartmentHdr departmentHdr=departmentHdrDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", departmentHdr.getId());
		result.put("isActive", departmentHdr.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveDepartmentDtl(Integer id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save departmentDtl execute");
		
		DepartmentDtl model = departmentDtlDao.findById(id);
		
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
		
		DepartmentDtl departmentDtl=departmentDtlDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", departmentDtl.getId());
		result.put("isActive", departmentDtl.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findDetailByParent(String Id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listDepartmentDtl", departmentDtlDao.findByDepartmentHdrId(Id));
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findDetailById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		DepartmentDtl departmentDtl=departmentDtlDao.findById(new Integer(id));
		result.put("departmentDtl", departmentDtl);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteDepartmentDtl(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		DepartmentDtl departmentDtl = departmentDtlDao.findById(new Integer(id));
		departmentDtlDao.delete(departmentDtl);
		result.put("id", id);
		return result;
	}
	
}
