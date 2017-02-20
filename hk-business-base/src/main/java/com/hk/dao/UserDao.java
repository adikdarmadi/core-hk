package com.hk.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.LoginUser;
import com.hk.entities.User;


/**
 * 
 * 
 * @author Adik
 */
@Repository("UserDao")
public interface UserDao extends PagingAndSortingRepository<User, String> {

	List<User> findById(String id);
	
}
