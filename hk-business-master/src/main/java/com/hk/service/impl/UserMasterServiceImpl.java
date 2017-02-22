package com.hk.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.PegawaiDao;
import com.hk.dao.UserDao;
import com.hk.entities.User;
import com.hk.service.UserMasterService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.util.PasswordUtil;
import com.hk.vo.UserVO;

/**
 * Implement class for UserService
 * 
 * @author Adhityarismawan
 */
@Service("UserMasterService")
public class UserMasterServiceImpl implements UserMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PegawaiDao pegawaiDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveUser(UserVO p) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save user execute");
		User model=modelMapper.map(p, User.class);
		model.setId(model.getId().toUpperCase());
		
		PasswordUtil passwordUtil = new PasswordUtil();
		model.setPassword(passwordUtil.encryptPassword(p.getPassword()));
		
		model.setCreateBy(userService.getUser().getId());
		model.setCreateDate(DateUtil.now());
		model.setIsActive(true);
		
		if(CommonUtil.isNotNullOrEmpty(model.getPegawaiId())){
			model.setPegawai(pegawaiDao.findById(model.getPegawaiId()));
		}
		
		User user=userDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", user.getId());
		result.put("isActive", user.getIsActive());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findAllUser() {
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("listUser", userDao.findAllUser());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findById(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		User user=userDao.findById(id);
		result.put("user", user);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> deleteUser(String id) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		userDao.delete(id);
		result.put("id", id);
		return result;
	}
	
}
