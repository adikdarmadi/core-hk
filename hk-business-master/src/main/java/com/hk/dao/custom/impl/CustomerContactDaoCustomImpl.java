package com.hk.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hk.dao.custom.CustomerContactDaoCustom;

/**
 * Repository Custom class
 * 
 * @author Adhityarismawan
 */

@Repository("CustomerContactDaoCustom")
public class CustomerContactDaoCustomImpl  implements CustomerContactDaoCustom {

	@PersistenceContext
	protected EntityManager em;
	
	
	@Override
	public int getLastIndexCount(String customerId){

		StringBuffer buffer = new StringBuffer();

		buffer.append("select model.indexCount from CustomerContact model where model.customerId =:customerId order by model.indexCount desc ");

		Query query = em.createQuery(buffer.toString());
		query.setParameter("customerId", customerId);
		
		query.setMaxResults(1);
		
		return ((Integer) query.getSingleResult()).intValue();
	}

	

}
