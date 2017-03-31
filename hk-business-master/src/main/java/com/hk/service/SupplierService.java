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

	Map<String, Object> editSupplier(SupplierVO p, Integer version);

	Map<String, Object> editSupplierContact(SupplierContactVO p, String id, Integer version);

	Map<String, Object> isActiveSupplier(String id, Integer version);

	Map<String, Object> isActiveSupplierContact(String id, Integer version);

	Map<String, Object> findDistinctGroup();

}
