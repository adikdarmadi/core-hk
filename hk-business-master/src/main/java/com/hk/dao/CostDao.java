package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Cost;

@Repository("CostDao")
public interface CostDao extends PagingAndSortingRepository<Cost, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.grupId as grupId,m.saldoAwal as saldoAwal,m.tglAwal as tglAwal,"
			+ "m.mataUangId as mataUangId,n.id as akunId,n.nama as akunNama, m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from Cost m left join m.akun n ")
	List<Map<String,Object>> findAllCost();
	
	Cost findById(String id);

}
