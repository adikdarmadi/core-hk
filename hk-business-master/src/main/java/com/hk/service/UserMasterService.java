package com.hk.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import com.hk.entities.User;
import com.hk.vo.UserVO;


/**
 * User Master Service
 * 
 * @author Adhityarismawan
 */
public interface UserMasterService{
	
	Map<String, Object> findAllUser(Map<String, String> pathVariables);

	Map<String, Object> saveUser(UserVO p) throws NoSuchAlgorithmException, UnsupportedEncodingException;

	Map<String, Object> findById(String id);

	Map<String, Object> deleteUser(String id);

	Map<String, Object> editUser(UserVO p, Integer version);

	Map<String, Object> isActiveUser(String id, Integer version);

	Map<String, Object> findGudangCheckByUserId(String userId);

	Map<String, Object> findRoleCheckByUserId(String userId);

	Map<String, Object> findKasBankCheckByUserId(String userId);

	Map<String, Object> findByGudangId(String gudangId);

	Map<String, Object> findByRoleId(String roleId);

	Map<String, Object> findByKasBankId(String kasBankId);
	
	Map<String, Object> findvUser();
	
}
