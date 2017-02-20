package com.hk.service;

import java.util.Map;

import com.hk.vo.AkunGrupVO;

/**
 * Agama Service
 * 
 * @author Adik
 */
public interface AkunGrupService {

	Map<String, Object> findAllAkunGrup();

	Map<String, Object> saveAkunGrup(AkunGrupVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteAkunGrup(String id);

}
