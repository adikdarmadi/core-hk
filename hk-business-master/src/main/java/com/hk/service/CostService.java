package com.hk.service;

import java.util.Map;

import com.hk.vo.CostVO;

/**
 * Cost Service
 * 
 * @author Adhityarismawan
 */
public interface CostService {

	Map<String, Object> findAllCost(Map<String, String> pathVariables);

	Map<String, Object> saveCost(CostVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteCost(String id);

	Map<String, Object> editCost(CostVO p, Integer version);

	Map<String, Object> isActiveCost(String id, Integer version);

}
