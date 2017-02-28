package com.hk.service;

import java.util.Map;

import com.hk.vo.AkunVO;

/**
 * Akun Service
 * 
 * @author Adhityarismawan
 */
public interface AkunService {

	Map<String, Object> findAllAkun();

	Map<String, Object> saveAkun(AkunVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteAkun(String id);

	Map<String, Object> editAkun(AkunVO p, Integer version);

}
