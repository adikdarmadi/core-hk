package com.hk.service;

import java.util.Map;

import com.hk.vo.SalesVO;

/**
 * Sales Service
 * 
 * @author Adhityarismawan
 */
public interface SalesService {

	Map<String, Object> findAllSales();

	Map<String, Object> saveSales(SalesVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteSales(String id);

}
