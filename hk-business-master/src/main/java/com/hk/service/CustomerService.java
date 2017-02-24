package com.hk.service;

import java.util.Map;

import com.hk.vo.CustomerContactVO;
import com.hk.vo.CustomerVO;

/**
 * Customer Service
 * 
 * @author Adhityarismawan
 */

public interface CustomerService {

	Map<String, Object> findAllCustomer();

	Map<String, Object> saveCustomer(CustomerVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteCustomer(String id);
	
	Map<String, Object> saveCustomerContact(CustomerContactVO entity);

	Map<String, Object> findDetailByParent(String id);

	Map<String, Object> findDetailById(String id);

	Map<String, Object> deleteCustomerContact(String id);

}
