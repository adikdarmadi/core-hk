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
import com.hk.entities.DepartmentDtl;
import com.hk.entities.DepartmentHdr;
import com.hk.entities.Widget;
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

		/*if(CommonUtil.isNotNullOrEmpty(model.getProspekId())){
			model.setProspek(prospekDao.findById(model.getProspekId()));
		}*/
		
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
	public Map<String,Object> editCustomer(CustomerVO p, Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save customer execute");
		Customer model=modelMapper.map(p, Customer.class);

		Customer obj = customerDao.findById(p.getId());
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);

		/*if(CommonUtil.isNotNullOrEmpty(model.getProspekId())){
			model.setProspek(prospekDao.findById(model.getProspekId()));
		}*/
		
		if(CommonUtil.isNotNullOrEmpty(model.getKasBankId())){
			model.setKasBank(kasBankDao.findById(model.getKasBankId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getAkunId())){
			model.setAkun(akunDao.findById(model.getAkunId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(model.getSalesId())){
			model.setSales(salesDao.findById(model.getSalesId()));
		}
		
		Customer customer=customerDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", customer.getId());
		result.put("isActive", customer.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveCustomer(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save customer execute");
		
		Customer model = customerDao.findById(id);
		
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
		
		Customer customer=customerDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", customer.getId());
		result.put("isActive", customer.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> isActiveCustomerContact(String id, Integer version){
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save customerContact execute");
		
		CustomerContact model = customerContactDao.findById(id);
		
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
		
		CustomerContact customerContact=customerContactDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", customerContact.getId());
		result.put("isActive", customerContact.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllCustomer(Map<String, String> pathVariables) {
		Map<String,Object> result=new HashMap<String,Object>();
		
		List<Object> listMap = new ArrayList<Object>();
		for(Map<String, Object> map : customerDao.findAllCustomer()){
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
		
		result.put("listCustomer", listMap);
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
	public Map<String,Object> editCustomerContact(CustomerContactVO p, String id, Integer version) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save customer execute");
		CustomerContact model=modelMapper.map(p, CustomerContact.class);
		
		CustomerContact obj = customerContactDao.findById(id);
		model.setCreateBy(obj.getCreateBy());
		model.setCreateDate(obj.getCreateDate());
		model.setIsActive(obj.getIsActive());
		
		model.setCustomer(obj.getCustomer());
		
		model.setLastUpdateBy(userService.getUser().getId());
		model.setLastUpdateDate(DateUtil.now());
		model.setVersion(version);
		
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
