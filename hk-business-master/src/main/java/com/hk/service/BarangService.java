package com.hk.service;

import java.util.Map;

import com.hk.vo.BarangVO;

/**
 * Barang Service
 * 
 * @author Adhityarismawan
 */
public interface BarangService {

	Map<String, Object> findAllBarang();

	Map<String, Object> saveBarang(BarangVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteBarang(String id);

	Map<String, Object> editBarang(BarangVO p, Integer version);

}
