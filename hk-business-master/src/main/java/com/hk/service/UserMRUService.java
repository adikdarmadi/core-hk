package com.hk.service;

import java.util.Map;

import com.hk.vo.UserMRUVO;

/**
 * UserMRU Service
 * 
 * @author Adhityarismawan
 */
public interface UserMRUService {

	Map<String, Object> findByUserIdLimit(String userId);

	Map<String, Object> saveUserMRU(UserMRUVO p);

}
