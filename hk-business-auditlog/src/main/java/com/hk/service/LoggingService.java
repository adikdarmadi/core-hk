package com.hk.service;


/**
 * User Service
 * 
 * @author Adhityarismawan
 */
public interface LoggingService{
	
	<T> void insertAuditLog(String action,T obj);

}
