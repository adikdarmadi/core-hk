package com.hk.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hk.dao.custom.AgamaDaoCustom;
import com.hk.dao.custom.SupplierContactDaoCustom;

/**
 * Repository Custom class
 * 
 * @author Adhityarismawan
 */

@Repository("SupplierContactDaoCustom")
public class SupplierContactDaoCustomImpl  implements SupplierContactDaoCustom {

	protected EntityManager em;
	
	
	@Override
	public int getLastIndexCount(String supplierId){

		StringBuffer buffer = new StringBuffer();

		buffer.append("select model.indexCount from SupplierContact model where model.supplierId =:supplierId order by model.indexCount desc ");

		Query query = em.createQuery(buffer.toString());
		query.setParameter("supplierId", supplierId);
		
		query.setMaxResults(1);
		
		return ((Integer) query.getSingleResult()).intValue();
	}

	

}
