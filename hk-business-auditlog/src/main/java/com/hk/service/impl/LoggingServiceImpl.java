package com.hk.service.impl;


import java.lang.reflect.Field;

import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.dao.custom.LoggingJdbcDao;
import com.hk.dao.custom.ModuleLogDao;
import com.hk.entities.Module;
import com.hk.service.LoggingService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;

@Service("loggingService")
public class LoggingServiceImpl implements LoggingService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("LoggingService : ");

	@Autowired
	private UserService userService;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private LoggingJdbcDao loggingJdbcDao;
	
	@Autowired
	private ModuleLogDao moduleLogDao;
	
	@Override
	public <T> void insertAuditLog(String action, T obj) {
		// TODO Auto-generated method stub
		
		String id = "";
		try {
			Field field = obj.getClass().getDeclaredField("id");
			field.setAccessible(true);
			Object ids = field.get(obj);
			id = ids.toString();
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String mapping = "";
		try {
			mapping = Class.forName(Thread.currentThread().getStackTrace()[15].getClassName()).getAnnotation(RequestMapping.class).value()[0];
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Module m = moduleLogDao.findByPathMap(mapping);
		loggingJdbcDao.create(action, m.getNama()+", ID : "+id, userService.getUser().getId(), DateUtil.now(), id, 
				obj.getClass().getAnnotation(Table.class).name(), m.getNama());
	}

	

}
