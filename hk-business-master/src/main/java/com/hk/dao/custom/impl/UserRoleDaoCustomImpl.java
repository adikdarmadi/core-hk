package com.hk.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hk.dao.custom.UserRoleDaoCustom;

/**
 * Repository Custom class
 * 
 * @author Adhityarismawan
 */

@Repository("UserRoleDaoCustom")
public class UserRoleDaoCustomImpl  implements UserRoleDaoCustom {

	@PersistenceContext(name="dataSource")
	protected EntityManager em;
	
	@Override
	public void deleteByRoleId(String roleId) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from UserRole x where x.roleId =:roleId");

		Query query = em.createQuery(buffer.toString());

		query.setParameter("roleId", roleId);
		
		query.executeUpdate();
	}
	
	@Override
	public void deleteByUserId(String userId) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("delete from UserRole x where x.userId =:userId");

		Query query = em.createQuery(buffer.toString());

		query.setParameter("userId", userId);
		
		query.executeUpdate();
	}

}
