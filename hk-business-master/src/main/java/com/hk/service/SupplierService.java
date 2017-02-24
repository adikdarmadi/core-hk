package com.hk.service;

import java.util.Map;

import com.hk.vo.SupplierContactVO;
import com.hk.vo.SupplierVO;

/**
 * Supplier Service
 * 
 * @author Adhityarismawan
 */

public interface SupplierService {

	Map<String, Object> findAllSupplier();

	Map<String, Object> saveSupplier(SupplierVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteSupplier(String id);
	
	Map<String, Object> saveSupplierContact(SupplierContactVO entity);

	Map<String, Object> findDetailByParent(String id);

	Map<String, Object> findDetailById(String id);

	Map<String, Object> deleteSupplierContact(String id);

}
