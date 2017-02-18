package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.MataUang;
import com.hk.entities.Produk;

@Repository("MataUangDao")
public interface MataUangDao extends PagingAndSortingRepository<MataUang, String> {

	@Query("select new map (m.id as id,m.isActive as isActive) from MataUang m where m.isActive = true ")
	List<Map<String,Object>> findAllMataUang();
	
	MataUang findById(String id);

}
