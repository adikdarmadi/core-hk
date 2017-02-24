package com.hk.service;

import java.util.Map;

import com.hk.vo.BarangDivisiVO;

/**
 * Barang Divisi Service
 * 
 * @author Adhityarismawan
 */

public interface BarangDivisiService {

	Map<String, Object> findAllBarangDivisi();

	Map<String, Object> saveBarangDivisi(BarangDivisiVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteBarangDivisi(String id);

}
