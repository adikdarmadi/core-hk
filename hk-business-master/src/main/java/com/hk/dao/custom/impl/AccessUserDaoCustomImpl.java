package com.hk.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hk.dao.custom.AccessUserDaoCustom;

/**
 * Repository Custom class
 * 
 * @author Adhityarismawan
 */

@Repository("AccessUserDaoCustom")
public class AccessUserDaoCustomImpl  implements AccessUserDaoCustom {

	@PersistenceContext
	protected EntityManager em;
	
	
	@Override
	public void deleteByUserId(String userId) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from AccessUser x where x.userId =:userId");

		Query query = em.createQuery(buffer.toString());

		query.setParameter("userId", userId);
		
		query.executeUpdate();
	}

}
