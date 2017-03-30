package com.hk.dao.custom.impl;


import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hk.dao.custom.LoggingJdbcDao;
import com.hk.entities.Logging;
import com.mapper.LoggingMapper;



/**
 * simple implemmentation dao LoggingJdbcDao
 * 
 * @author Adik
 */
public class LoggingJdbcDaoImpl implements LoggingJdbcDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String action, String detail, String username,Date createdDate,String entityId,String entityName,String module) {
		String SQL = "insert into Logging (action, detail,username,created_date,entity_id,entity_name,module) values (?,?,?,?,?,?,?)";

		jdbcTemplateObject.update(SQL, action, detail,username,createdDate,entityId,entityName,module);
		return;
	}

	public Logging getLogging(Integer id) {
		String SQL = "select * from Logging where id = ?";
		Logging logging = jdbcTemplateObject.queryForObject(SQL,
				new Object[] { id }, new LoggingMapper());
		return logging;
	}

	public List<Logging> listLoggings() {
		String SQL = "select * from Logging";
		List<Logging> loggings = jdbcTemplateObject.query(SQL,
				new LoggingMapper());
		return loggings;
	}

	public void delete(Integer id) {
		String SQL = "delete from Logging where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;
	}

	public void update(Integer id, String nama, String deskripsi) {
		String SQL = "update Logging set nama = ?, deskripsi = ? where id = ?";
		jdbcTemplateObject.update(SQL, nama, deskripsi, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

}