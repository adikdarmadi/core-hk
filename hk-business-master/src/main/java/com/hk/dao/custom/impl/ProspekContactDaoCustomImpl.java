package com.hk.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hk.dao.custom.ProspekContactDaoCustom;

/**
 * Repository Custom class
 * 
 * @author Adhityarismawan
 */

@Repository("ProspekContactDaoCustom")
public class ProspekContactDaoCustomImpl  implements ProspekContactDaoCustom {

	@PersistenceContext(unitName="persistenceUnit")
	@Qualifier(value = "entityManagerFactory")
	protected EntityManager em;
	
	
	@Override
	public int getLastIndexCount(String prospekId){

		StringBuffer buffer = new StringBuffer();

		buffer.append("select model.indexCount from ProspekContact model where model.prospekId =:prospekId order by model.indexCount desc ");

		Query query = em.createQuery(buffer.toString());
		query.setParameter("prospekId", prospekId);
		
		query.setMaxResults(1);
		
		return ((Integer) query.getSingleResult()).intValue();
	}

	

}
