package com.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hk.entities.Logging;


/**
 * Mapper class for Logging, contoh saja
 * 
 * @author Roberto
 */
public class LoggingMapper implements RowMapper<Logging> {
	public Logging mapRow(ResultSet rs, int rowNum) throws SQLException {
		Logging log = new Logging();
		log.setAuditLogId(new Long(rs.getInt("audit_log_id")));
		log.setAction(rs.getString("action"));
		log.setDetail(rs.getString("detail"));
		log.setUsername(rs.getString("username"));
		log.setCreatedDate(rs.getDate("created_date"));
		log.setEntityId(rs.getString("entity_id"));
		log.setEntityName(rs.getString("entity_name"));
		log.setModule(rs.getString("module"));
		return log;
	}
}