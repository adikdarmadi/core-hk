package com.hk.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.UserDao;
import com.hk.entities.LoginUser;
import com.hk.entities.User;
import com.hk.service.UserService;
import com.hk.util.PasswordUtil;
import com.hk.vo.AuthVO;
import com.hk.vo.LoginUserVO;

/**
 * Implement class for LoginUserService
 * 
 * @author Adik
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser() {
		List<User> user = null;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String id = principal.toString();
            user = userDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.get(0);
    }
	
	
}
