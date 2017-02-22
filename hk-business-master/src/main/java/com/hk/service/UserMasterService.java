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
	
	Map<String, Object> findAllUser();

	Map<String, Object> saveUser(UserVO p) throws NoSuchAlgorithmException, UnsupportedEncodingException;

	Map<String, Object> findById(String id);

	Map<String, Object> deleteUser(String id);
	
}
