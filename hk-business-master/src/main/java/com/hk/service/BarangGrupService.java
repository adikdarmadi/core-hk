package com.hk.service;

import java.util.Map;

import com.hk.vo.BarangGrupVO;

/**
 * Barang Grup Service
 * 
 * @author Adhityarismawan
 */

public interface BarangGrupService {

	Map<String, Object> findAllBarangGrup();

	Map<String, Object> saveBarangGrup(BarangGrupVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteBarangGrup(String id);

}
