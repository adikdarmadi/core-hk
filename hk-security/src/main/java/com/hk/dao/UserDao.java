package com.hk.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.User;


/**
 * 
 * 
 * @author Adhityarismawan
 */
@Repository("UserDao")
public interface UserDao extends PagingAndSortingRepository<User, String> {

	User findById(String id);
	
}
