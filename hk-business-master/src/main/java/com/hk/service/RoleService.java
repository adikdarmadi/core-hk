package com.hk.service;

import java.util.Map;

import com.hk.vo.RoleVO;

/**
 * Role Service
 * 
 * @author Adhityarismawan
 */
public interface RoleService {

	Map<String, Object> findAllRole();

	Map<String, Object> saveRole(RoleVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteRole(String id);

	Map<String, Object> editRole(RoleVO p, Integer version);

	Map<String, Object> isActiveRole(String id, Integer version);

	Map<String, Object> findByUserId(String userId);

}
