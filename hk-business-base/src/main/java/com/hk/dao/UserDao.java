package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.User;


/**
 * 
 * 
 * @author Adhityarismawan
 */
@Repository("UserDao")
public interface UserDao extends PagingAndSortingRepository<User, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.mruLimit as mruLimit,m.isCreate as isCreate,m.isUpdate as isUpdate,"
			+ "m.isDelete as isDelete,m.isPrint as isPrint,m.isCancel as isCancel,m.isReport as isReport,m.isSupervisor as isSupervisor, "
			+ "m.isConfirm as isConfirm,m.isUnconfirm as isUnconfirm,m.isSuperuser as isSuperuser,n.id as pegawaiId,n.nama as pegawaiNama,"
			+ "m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from User m left join m.pegawai n ")
	List<Map<String,Object>> findAllUser();
	
	User findById(String id);
	
}
