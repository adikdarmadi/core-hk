package com.hk.dao.custom;


import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.hk.entities.Logging;


/**
 * simple dao LoggingJdbcDao
 * 
 * @author Roberto
 */
public interface LoggingJdbcDao {
	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the Logging table.
	 */
	public void create(String action, String detail, String username,Date createdDate,String entityId,String entityName,String module);

	/**
	 * This is the method to be used to list down a record from the Logging
	 * table corresponding to a passed logging id.
	 */
	public Logging getLogging(Integer id);

	/**
	 * This is the method to be used to list down all the records from the
	 * Logging table.
	 */
	public List<Logging> listLoggings();

	/**
	 * This is the method to be used to delete a record from the Logging table
	 * corresponding to a passed student id.
	 */
	public void delete(Integer id);

	/**
	 * This is the method to be used to update a record into the Logging table.
	 */
	public void update(Integer id, String nama, String deskripsi);
}