package com.hk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.AkunDao;
import com.hk.dao.MataUangDao;
import com.hk.dao.SupplierContactDao;
import com.hk.dao.SupplierDao;
import com.hk.dao.custom.SupplierContactDaoCustom;
import com.hk.entities.Supplier;
import com.hk.entities.SupplierContact;
import com.hk.service.SupplierService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.SupplierContactVO;
import com.hk.vo.SupplierVO;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("SupplierService : ");

	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private SupplierContactDao supplierContactDao;
	
	@Autowired
	private SupplierContactDaoCustom supplierContactDaoCustom;
	
	@Autowired
	private AkunDao akunDao;
	
	@Autowired
	private MataUangDao mataUangDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveSupplier(SupplierVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save supplier execute");
		Supplier model=modelMapper.map(p, Supplier.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getMataUangId())){
			model.setMataUang(mataUangDao.findById(model.getMataUangId()));
		}
		
		List<SupplierContact> tmpListSupplierContact = new ArrayList<>();
		int counter = 1;
		for(SupplierContact supplierContact : model.getListSupplierContact()){
			supplierContact.setId(model.getId()+"-"+counter);
			supplierContact.setCreateDate(DateUtil.now());
			supplierContact.setCreateBy(userService.getUser().getId());
			supplierContact.setIsActive(true);
			supplierContact.setSupplier(model);
			supplierContact.setIndexCount(counter);
			tmpListSupplierContact.add(supplierContact);
			counter++;
		}
		
		model.getListSupplierContact().clear();
		model.getListSupplierContact().addAll(tmpListSupplierContact);
		
		Supplier supplier=supplierDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", supplier.getId());
		result.put("isActive", supplier.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllSupplier() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listSupplier", supplierDao.findAllSupplier());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Supplier supplier=supplierDao.findById(id);
		result.put("supplier", supplier);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteSupplier(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		supplierDao.delete(id);
		result.put("id", id);
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveSupplierContact(SupplierContactVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save supplier execute");
		SupplierContact model=modelMapper.map(p, SupplierContact.class);
		
		model.setIndexCount(getIndexCount(model.getSupplierId()));
		model.setId(model.getSupplierId()+"-"+model.getIndexCount());
		
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getSupplierId())){
			model.setSupplier(supplierDao.findById(model.getSupplierId()));
		}
		
		SupplierContact supplierContact=supplierContactDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", supplierContact.getId());
		result.put("isActive", supplierContact.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findDetailByParent(String Id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listSupplierContact", supplierContactDao.findBySupplierId(Id));
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findDetailById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		SupplierContact supplierContact=supplierContactDao.findById(id);
		result.put("supplierContact", supplierContact);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteSupplierContact(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		supplierContactDao.delete(id);
		result.put("id", id);
		return result;
	}
	
	public Integer getIndexCount(String supplierId){
		Integer lastIndexCount = supplierContactDaoCustom.getLastIndexCount(supplierId);
		lastIndexCount++;
		return lastIndexCount;
	}
}
