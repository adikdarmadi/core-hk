package com.hk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.AccessUser;

@Repository("AccessUserDao")
public interface AccessUserDao extends PagingAndSortingRepository<AccessUser, String> {

	@Query("select au from AccessUser au where au.userId =:userId and au.moduleId = :moduleId ")
	AccessUser findByUserIdModuleId(@Param("userId") String userId,@Param("moduleId") String moduleId);
	
	List<AccessUser> findByUserId(String userId);
}
