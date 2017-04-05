package com.hk.service;

import java.util.Map;

import com.hk.vo.BarangDivisiVO;

/**
 * Barang Divisi Service
 * 
 * @author Adhityarismawan
 */

public interface BarangDivisiService {

	Map<String, Object> findAllBarangDivisi(Map<String, String> pathVariables);

	Map<String, Object> saveBarangDivisi(BarangDivisiVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteBarangDivisi(String id);

	Map<String, Object> editBarangDivisi(BarangDivisiVO entity, Integer version);

	Map<String, Object> isActiveBarangDivisi(String id, Integer version);

}
