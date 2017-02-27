package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.DepartmentDtl;

@Repository("DepartmentDtlDao")
public interface DepartmentDtlDao extends PagingAndSortingRepository<DepartmentDtl, String> {

	@Query("select new map (m.id as id,m.shift as shift,m.jamMasuk as jamMasuk,m.jamKeluar as jamKeluar,"
			+ "m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from DepartmentDtl m where m.departmentHdrId = :departmentHdrId ")
	List<Map<String,Object>> findByDepartmentHdrId(@Param("departmentHdrId") String departmentHdrId);
	
	DepartmentDtl findById(Integer id);

}
