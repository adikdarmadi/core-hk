package com.hk.service.impl;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.UserDao;
import com.hk.entities.User;
import com.hk.service.LoginUserService;
import com.hk.util.CommonUtil;
import com.hk.util.PasswordUtil;
import com.hk.vo.AuthVO;
import com.hk.vo.UserVO;

/**
 * Implement class for LoginUserService
 * 
 * @author Adik
 */
@Service("LoginUserService")
public class LoginUserServiceImpl implements LoginUserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginUserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserVO signIn(AuthVO authVO)  {

		User users = userDao.findById(authVO.getId());
		if (CommonUtil.isNotNullOrEmpty(users)) {

			if(!users.getIsActive()){
				LOGGER.error("User not active");
				return null;
			}
			
			User user = users;
			PasswordUtil passwordUtil = new PasswordUtil();
			Boolean isValidPassword = false;
			try {
				isValidPassword = passwordUtil.isPasswordEqual(authVO.getPassword(), user.getPassword());
			} catch (IOException ioe) {
				LOGGER.error("Password not match : " + ioe.getMessage());
				return null;
			}

			if (!isValidPassword) {
				LOGGER.error("Password do not match");
				return null;
			}
			// to do validasi yang advanced di sini

			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			UserVO vo = modelMapper.map(user, UserVO.class);
			/*vo.setId(authVO.getId());
			vo.setPassword(authVO.getPassword());*/
			return vo;

		} else {
			LOGGER.error("User not found");
			return null;
		}
	}


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
