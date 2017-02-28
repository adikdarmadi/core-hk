package com.hk.dao.custom;

/**
 * 
 * @author Adhityarismawan
 */
public interface UserGudangDaoCustom  {

	void deleteByGudangId(String gudangId);
	
	void deleteByUserId(String userId);
}
