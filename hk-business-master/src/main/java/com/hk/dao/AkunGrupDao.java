package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.AkunGrup;

@Repository("AkunGrupDao")
public interface AkunGrupDao extends PagingAndSortingRepository<AkunGrup, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.isActive as isActive, m.version as version, m.createBy as createBy, m.createDate as createDate) from AkunGrup m ")
	List<Map<String,Object>> findAllAkunGrup();
	
	AkunGrup findById(String id);

}
