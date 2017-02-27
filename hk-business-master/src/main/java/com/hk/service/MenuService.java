package com.hk.service;

import java.util.Map;

/**
 * Menu Service
 * 
 * @author Adhityarismawan
 */
public interface MenuService {

	Map<String, Object> findAccessUserByUserId(String id);

}
