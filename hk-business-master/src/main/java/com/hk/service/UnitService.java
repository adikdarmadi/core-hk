package com.hk.service;

import java.util.Map;

import com.hk.vo.UnitVO;

/**
 * Unit Service
 * 
 * @author Adhityarismawan
 */
public interface UnitService {

	Map<String, Object> findAllUnit();

	Map<String, Object> saveUnit(UnitVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteUnit(String id);

}
