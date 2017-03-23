package com.hk.daoLog;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entitiesAuditLog.AuditLog;


/**
 * 
 * 
 * @author Adhityarismawan
 */
@Repository("AuditLogDao")
public interface AuditLogDao extends PagingAndSortingRepository<AuditLog, String> {

}
