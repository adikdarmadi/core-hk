package com.hk.service;

import java.util.Map;

import com.hk.vo.GudangGrupVO;

/**
 * Gudang Grup Service
 * 
 * @author Adhityarismawan
 */
public interface GudangGrupService {

	Map<String, Object> findAllGudangGrup();

	Map<String, Object> saveGudangGrup(GudangGrupVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteGudangGrup(String id);

}
