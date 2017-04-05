package com.hk.service;

import java.util.Map;

import com.hk.vo.BarangMerkVO;

/**
 * Barang Merk Service
 * 
 * @author Adhityarismawan
 */

public interface BarangMerkService {

	Map<String, Object> findAllBarangMerk(Map<String, String> pathVariables);

	Map<String, Object> saveBarangMerk(BarangMerkVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteBarangMerk(String id);

	Map<String, Object> editBarangMerk(BarangMerkVO p, Integer version);

	Map<String, Object> isActiveBarangMerk(String id, Integer version);

}
