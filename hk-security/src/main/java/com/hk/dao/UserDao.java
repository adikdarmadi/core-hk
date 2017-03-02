package com.hk.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.AccessUser;
import com.hk.entities.User;


/**
 * 
 * 
 * @author Adhityarismawan
 */

@Repository("UserDao")
public interface UserDao extends PagingAndSortingRepository<User, String> {

	User findById(String id);
	
	@Query("select au from AccessUser au left join au.module m left join au.user u where au.userId =:userId and m.pathMap = :pathMap "
			+ "and m.isActive = true and u.isActive = true ")
	AccessUser findByUserIdPathMap(@Param("userId") String userId,@Param("pathMap") String pathMap);
}
