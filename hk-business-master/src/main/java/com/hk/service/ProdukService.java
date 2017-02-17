package com.hk.service;

import java.util.Map;

import com.hk.entities.Produk;
import com.hk.vo.ProdukVO;

/**
 * Agama Service
 * 
 * @author Adik
 */
public interface ProdukService {

	Map<String, Object> findAllProduk();

	Map<String, Object> saveProduk(ProdukVO p);

	Map<String, Object> findById(Integer id);

}
