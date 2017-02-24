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

import com.hk.dao.AkunDao;
import com.hk.dao.CustomerContactDao;
import com.hk.dao.CustomerDao;
import com.hk.dao.KasBankDao;
import com.hk.dao.ProspekDao;
import com.hk.dao.SalesDao;
import com.hk.dao.custom.CustomerContactDaoCustom;
import com.hk.entities.Customer;
import com.hk.entities.CustomerContact;
import com.hk.service.CustomerService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.CustomerContactVO;
import com.hk.vo.CustomerVO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("CustomerService : ");

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerContactDao customerContactDao;
	
	@Autowired
	private CustomerContactDaoCustom customerContactDaoCustom;
	
	@Autowired
	private SalesDao salesDao;
	
	@Autowired
	private KasBankDao kasBankDao;
	
	@Autowired
	private AkunDao akunDao;
	
	@Autowired
	private ProspekDao prospekDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveCustomer(CustomerVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save customer execute");
		Customer model=modelMapper.map(p, Customer.class);
		model.setId(model.getId().toUpperCase());
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);

		if(CommonUtil.isNotNullOrEmpty(model.getProspekId())){
			model.setProspek(prospekDao.findById(model.getProspekId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getKasBankId())){
			model.setKasBank(kasBankDao.findById(model.getKasBankId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getSalesId())){
			model.setSales(salesDao.findById(model.getSalesId()));
		}
		
		List<CustomerContact> tmpListCustomerContact = new ArrayList<>();
		int counter = 1;
		for(CustomerContact customerContact : model.getListCustomerContact()){
			customerContact.setId(model.getId()+"-"+counter);
			customerContact.setCreateDate(DateUtil.now());
			customerContact.setCreateBy(userService.getUser().getId());
			customerContact.setIsActive(true);
			customerContact.setCustomer(model);
			customerContact.setIndexCount(counter);
			tmpListCustomerContact.add(customerContact);
			counter++;
		}
		
		model.getListCustomerContact().clear();
		model.getListCustomerContact().addAll(tmpListCustomerContact);
		
		Customer customer=customerDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", customer.getId());
		result.put("isActive", customer.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllCustomer() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listCustomer", customerDao.findAllCustomer());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		Customer customer=customerDao.findById(id);
		result.put("customer", customer);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteCustomer(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		customerDao.delete(id);
		result.put("id", id);
		return result;
	}

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveCustomerContact(CustomerContactVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save customer execute");
		CustomerContact model=modelMapper.map(p, CustomerContact.class);
		
		model.setIndexCount(getIndexCount(model.getCustomerId()));
		model.setId(model.getCustomerId()+"-"+model.getIndexCount());
		
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getCustomerId())){
			model.setCustomer(customerDao.findById(model.getCustomerId()));
		}
		
		CustomerContact customerContact=customerContactDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", customerContact.getId());
		result.put("isActive", customerContact.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findDetailByParent(String Id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listCustomerContact", customerContactDao.findByCustomerId(Id));
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findDetailById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		CustomerContact customerContact=customerContactDao.findById(id);
		result.put("customerContact", customerContact);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteCustomerContact(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		customerContactDao.delete(id);
		result.put("id", id);
		return result;
	}
	
	public Integer getIndexCount(String customerId){
		Integer lastIndexCount = customerContactDaoCustom.getLastIndexCount(customerId);
		lastIndexCount++;
		return lastIndexCount;
	}
}
