package com.hk.service;

import java.util.Map;

import com.hk.vo.BarangTipeVO;

/**
 * Barang Tipe Service
 * 
 * @author Adhityarismawan
 */

public interface BarangTipeService {

	Map<String, Object> findAllBarangTipe(Map<String, String> pathVariables);

	Map<String, Object> saveBarangTipe(BarangTipeVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteBarangTipe(String id);

	Map<String, Object> editBarangTipe(BarangTipeVO p, Integer version);

	Map<String, Object> isActiveBarangTipe(String id, Integer version);

}
