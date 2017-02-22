package com.hk.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hk.dao.UserDao;
import com.hk.entities.User;
import com.hk.service.UserService;

/**
 * Implement class for UserService
 * 
 * @author Adhityarismawan
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser() {
		User user = null;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String id = principal.toString();
            user = userDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
	
	
}
