package com.hk.service;

import com.hk.entities.LoginUser;
import com.hk.vo.AuthVO;
import com.hk.vo.LoginUserVO;


/**
 * LoginUser Service
 * 
 * @author Adik
 */
public interface LoginUserService{
	
	LoginUserVO signIn(AuthVO authVO);
	
	LoginUser getLoginUser();

}
