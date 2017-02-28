package com.hk.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hk.dao.custom.RoleWidgetDaoCustom;

/**
 * Repository Custom class
 * 
 * @author Adhityarismawan
 */

@Repository("RoleWidgetDaoCustom")
public class RoleWidgetDaoCustomImpl  implements RoleWidgetDaoCustom {

	@PersistenceContext
	protected EntityManager em;
	
	
	@Override
	public void deleteByRoleId(String roleId) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from RoleWidget x where x.roleId =:roleId");

		Query query = em.createQuery(buffer.toString());

		query.setParameter("roleId", roleId);
		
		query.executeUpdate();
	}

	@Override
	public void deleteByWidgetId(String widgetId) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from RoleWidget x where x.widgetId =:widgetId");

		Query query = em.createQuery(buffer.toString());

		query.setParameter("widgetId", widgetId);
		
		query.executeUpdate();
	}

}
