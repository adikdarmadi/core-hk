package com.hk.service;

import java.util.Map;

import com.hk.vo.GudangVO;

/**
 * Gudang Service
 * 
 * @author Adhityarismawan
 */
public interface GudangService {

	Map<String, Object> findAllGudang();

	Map<String, Object> saveGudang(GudangVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteGudang(String id);

}
