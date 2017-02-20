package com.hk.service;

import com.hk.entities.LoginUser;
import com.hk.entities.User;
import com.hk.vo.AuthVO;
import com.hk.vo.LoginUserVO;
import com.hk.vo.UserVO;


/**
 * LoginUser Service
 * 
 * @author Adik
 */
public interface LoginUserService{
	
	UserVO signIn(AuthVO authVO);
	
	User getUser();

}
