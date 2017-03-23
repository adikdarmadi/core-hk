package com.hk.service.impl;

import java.lang.reflect.Field;

import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.daoLog.AuditLogDao;
import com.hk.entitiesAuditLog.AuditLog;
import com.hk.service.AuditLogService;
import com.hk.service.UserService;
import com.hk.util.DateUtil;

@Service("auditLogService")
public class AuditLogServiceImpl<T> implements AuditLogService<T> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("AuditLogService : ");

	@Autowired
	private AuditLogDao auditLogDao;
	 
	@Autowired
	private UserService userService;
	

	@Override
	public void insertAuditLog(T obj, String action) {
		// TODO Auto-generated method stub
		
		AuditLog auditLog=new AuditLog();
		auditLog.setAction(action);
		auditLog.setCreatedDate(DateUtil.now());
		Object id = null;
		try {
			Field field;
			field = obj.getClass().getDeclaredField("id");
			field.setAccessible(true);
			id = field.get(obj);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		auditLog.setEntityId(id.toString());
		
		Table table = obj.getClass().getAnnotation(Table.class);
		auditLog.setEntityName(table.name());
		auditLog.setUsername(userService.getUser().getId());
		
		auditLog.setDetail(obj.getClass().getSimpleName()+", ID : "+id);
		auditLog.setModule(obj.getClass().getSimpleName());
		
		auditLogDao.save(auditLog);
	}
	
	
}
