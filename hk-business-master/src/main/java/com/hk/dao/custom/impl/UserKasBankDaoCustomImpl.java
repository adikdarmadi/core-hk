package com.hk.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hk.dao.custom.UserKasBankDaoCustom;

/**
 * Repository Custom class
 * 
 * @author Adhityarismawan
 */

@Repository("UserKasBankDaoCustom")
public class UserKasBankDaoCustomImpl  implements UserKasBankDaoCustom {

	@PersistenceContext(name="dataSource")
	protected EntityManager em;
	
	@Override
	public void deleteByKasBankId(String kasBankId) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from UserKasBank x where x.kasBankId =:kasBankId");

		Query query = em.createQuery(buffer.toString());

		query.setParameter("kasBankId", kasBankId);
		
		query.executeUpdate();
	}
	
	@Override
	public void deleteByUserId(String userId) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from UserKasBank x where x.userId =:userId");

		Query query = em.createQuery(buffer.toString());

		query.setParameter("userId", userId);
		
		query.executeUpdate();
	}

}
