package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Gudang;

@Repository("GudangDao")
public interface GudangDao extends PagingAndSortingRepository<Gudang, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.alamat as alamat,m.tglAwalStock as tglAwalStock,m.isBooked as isBooked,"
			+ "m.isPutihkan as isPutihkan,n.id as gudangGrupId,n.nama as gudangGrupNama, m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from Gudang m left join m.gudangGrup n ")
	List<Map<String,Object>> findAllGudang();
	
	Gudang findById(String id);
	
	List<Gudang> findByIsActive(Boolean isActive);

}
