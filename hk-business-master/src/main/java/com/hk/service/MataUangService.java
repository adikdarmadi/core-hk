package com.hk.service;

import java.util.Map;

import com.hk.entities.Produk;
import com.hk.vo.MataUangVO;
import com.hk.vo.ProdukVO;

/**
 * Agama Service
 * 
 * @author Adik
 */
public interface MataUangService {

	Map<String, Object> findAllMataUang();

	Map<String, Object> saveMataUang(MataUangVO p);

	Map<String, Object> findById(String id);

}
