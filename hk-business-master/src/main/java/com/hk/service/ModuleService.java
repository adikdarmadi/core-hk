package com.hk.service;

import java.util.Map;

import com.hk.vo.ModuleVO;

/**
 * Module Service
 * 
 * @author Adhityarismawan
 */

public interface ModuleService {

	Map<String, Object> findAllModule();

	Map<String, Object> saveModule(ModuleVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteModule(String id);

}
