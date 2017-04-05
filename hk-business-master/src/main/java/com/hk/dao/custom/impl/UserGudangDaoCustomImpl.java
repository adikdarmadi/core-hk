package com.hk.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hk.dao.custom.UserGudangDaoCustom;

/**
 * Repository Custom class
 * 
 * @author Adhityarismawan
 */

@Repository("UserGudangDaoCustom")
public class UserGudangDaoCustomImpl  implements UserGudangDaoCustom {

	@PersistenceContext(name="dataSource")
	protected EntityManager em;
	
	
	@Override
	public void deleteByGudangId(String gudangId) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from UserGudang x where x.gudangId =:gudangId");

		Query query = em.createQuery(buffer.toString());

		query.setParameter("gudangId", gudangId);
		
		query.executeUpdate();
	}
	
	@Override
	public void deleteByUserId(String userId) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from UserGudang x where x.userId =:userId");

		Query query = em.createQuery(buffer.toString());

		query.setParameter("userId", userId);
		
		query.executeUpdate();
	}

}
