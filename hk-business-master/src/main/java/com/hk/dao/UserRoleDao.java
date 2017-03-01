package com.hk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.Role;
import com.hk.entities.UserRole;

@Repository("UserRoleDao")
public interface UserRoleDao extends PagingAndSortingRepository<UserRole, String> {

	@Query("select ur from UserRole ur where ur.userId =:userId and ur.roleId = :roleId ")
	UserRole findByUserIdRoleId(@Param("userId") String userId,@Param("roleId") String roleId);
	
	@Query("select g from UserRole ur left join ur.role g where ur.userId =:userId and g.isActive = true ")
	List<Role> findRoleByUserId(@Param("userId") String userId);
}
