package com.hk.service;

import java.util.Map;

import com.hk.vo.AccessUserVO;

/**
 * AccessUser Service
 * 
 * @author Adhityarismawan
 */
public interface AccessUserService {

	Map<String, Object> findByUserId(String userId);

	Map<String, Object> saveAccessUser(AccessUserVO entity);

	Map<String, Object> copyAccessUser(String toUser, String fromUser);

}
