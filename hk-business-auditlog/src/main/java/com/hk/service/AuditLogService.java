package com.hk.service;


/**
 * AuditLog Service
 * 
 * @author Adhityarismawan
 */

public interface AuditLogService<T>{
	
	 void insertAuditLog(T obj,String action);

}
