package com.hk.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hk.dao.custom.AgamaDaoCustom;

/**
 * Repository Custom class
 * 
 * @author Adik
 */
@Repository("AgamaDaoCustom")
public class AgamaDaoCustomImpl  implements AgamaDaoCustom {

	@PersistenceContext(unitName="persistenceUnit")
	@Qualifier(value = "entityManagerFactory")
	protected EntityManager em;
	
	
	@Override
	public int countAgama() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("select count(model.id) from  Agama model where  model.id is not null ");

		Query query = em.createQuery(buffer.toString());

		return ((Long) query.getSingleResult()).intValue();
	}

	

}
