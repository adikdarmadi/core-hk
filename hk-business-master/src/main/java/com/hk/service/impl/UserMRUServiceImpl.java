package com.hk.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.dao.ModuleDao;
import com.hk.dao.UserDao;
import com.hk.dao.UserMRUDao;
import com.hk.entities.User;
import com.hk.entities.UserMRU;
import com.hk.service.UserMRUService;
import com.hk.service.UserService;
import com.hk.util.CommonUtil;
import com.hk.util.DateUtil;
import com.hk.vo.UserMRUVO;

@Service("userMRUService")
public class UserMRUServiceImpl implements UserMRUService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("UserMRUService : ");

	@Autowired
	private UserMRUDao userMRUDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModuleDao moduleDao;
	
	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> saveUserMRU(UserMRUVO p) {
		//LOGGER.info(userService.getLoginUser().getNamaUser() +" save userMRU execute");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserMRU model=modelMapper.map(p, UserMRU.class);
		model.setTanggalAkses(DateUtil.now());
		
		if(CommonUtil.isNotNullOrEmpty(p.getUserId())){
			model.setUser(userDao.findById(p.getUserId()));
		}
		
		if(CommonUtil.isNotNullOrEmpty(p.getModuleId())){
			model.setModule(moduleDao.findById(p.getModuleId()));
		}
		
		UserMRU userMRU=userMRUDao.save(model);
		Map<String,Object> result=new HashMap<String,Object>(); 
		result.put("id", userMRU.getId());
		result.put("tanggalAkses", userMRU.getTanggalAkses());
		result.put("userId", userMRU.getUserId());
		result.put("moduleId", userMRU.getModuleId());
		return result;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Map<String,Object> findByUserIdLimit(String userId) {
		Map<String,Object> result=new HashMap<String,Object>(); 
		
		User user = userDao.findById(userId);
		result.put("listUserMRU", userMRUDao.findByUserId(userId, new PageRequest(0, user.getMruLimit())));
		
		return result;
	}
	

}
