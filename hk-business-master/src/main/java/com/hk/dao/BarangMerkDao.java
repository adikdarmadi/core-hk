package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.BarangMerk;

@Repository("BarangMerkDao")
public interface BarangMerkDao extends PagingAndSortingRepository<BarangMerk, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from BarangMerk m ")
	List<Map<String,Object>> findAllBarangMerk();
	
	BarangMerk findById(String id);

}
