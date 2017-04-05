package com.hk.service;

import java.util.Map;

import com.hk.vo.KasBankVO;

/**
 * KasBank Service
 * 
 * @author Adhityarismawan
 */
public interface KasBankService {

	Map<String, Object> findAllKasBank();

	Map<String, Object> saveKasBank(KasBankVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteKasBank(String id);

	Map<String, Object> editKasBank(KasBankVO p, Integer version);

	Map<String, Object> isActiveKasBank(String id, Integer version);

	Map<String, Object> findByUserId(String userId);

	Map<String, Object> findUserCheckByKasBankId(String kasBankId);

}
