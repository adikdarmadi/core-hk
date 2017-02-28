package com.hk.service;

import java.util.Map;

import com.hk.vo.ProspekContactVO;
import com.hk.vo.ProspekVO;

/**
 * Prospek Service
 * 
 * @author Adhityarismawan
 */

public interface ProspekService {

	Map<String, Object> findAllProspek();

	Map<String, Object> saveProspek(ProspekVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deleteProspek(String id);
	
	Map<String, Object> saveProspekContact(ProspekContactVO entity);

	Map<String, Object> findDetailByParent(String id);

	Map<String, Object> findDetailById(String id);

	Map<String, Object> deleteProspekContact(String id);

	Map<String, Object> editProspek(ProspekVO p, Integer version);

	Map<String, Object> editProspekContact(ProspekContactVO p, String id, Integer version);

	Map<String, Object> isActiveProspek(String id, Integer version);

	Map<String, Object> isActiveProspekContact(String id, Integer version);

}
