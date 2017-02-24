package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.SupplierContact;

@Repository("SupplierContactDao")
public interface SupplierContactDao extends PagingAndSortingRepository<SupplierContact, String> {

	@Query("select new map (m.id as id,m.pic as pic,m.divisi as divisi,m.department as department,m.telepon as telepon,"
			+ "m.hp as hp,m.fax as fax,m.email as email ,m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from SupplierContact m where m.supplierId = :supplierId ")
	List<Map<String,Object>> findBySupplierId(@Param("supplierId") String supplierId);
	
	SupplierContact findById(String id);

}
