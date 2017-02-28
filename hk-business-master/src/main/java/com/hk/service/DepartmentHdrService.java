package com.hk.service;

import java.util.Map;

import com.hk.vo.DepartmentDtlVO;
import com.hk.vo.DepartmentHdrVO;

/**
 * DepartmentHdr Service
 * 
 * @author Adhityarismawan
 */

public interface DepartmentHdrService {

	Map<String, Object> findAllDepartmentHdr();

	Map<String, Object> saveDepartmentHdr(DepartmentHdrVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteDepartmentHdr(String id);
	
	Map<String, Object> saveDepartmentDtl(DepartmentDtlVO entity);

	Map<String, Object> findDetailByParent(String id);

	Map<String, Object> findDetailById(String id);

	Map<String, Object> deleteDepartmentDtl(String id);

	Map<String, Object> editDepartmentHdr(DepartmentHdrVO p, Integer version);

	Map<String, Object> editDepartmentDtl(DepartmentDtlVO p, Integer id, Integer version);

	Map<String, Object> isActiveDepartmentHdr(String id, Integer version);

	Map<String, Object> isActiveDepartmentDtl(Integer id, Integer version);

}
