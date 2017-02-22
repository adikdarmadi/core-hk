package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Akun;

@Repository("AkunDao")
public interface AkunDao extends PagingAndSortingRepository<Akun, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.positionDk as positionDk,m.levelAkun as levelAkun,m.tipeAkun as tipeAkun,"
			+ "m.saldoAwal as saldoAwal,m.saldoYtd as saldoYtd,n.id as akunParentId,n.nama as akunParentNama,o.id as akunGrupId,o.nama as akunGrupNama ,m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from Akun m left join m.akunParent n left join m.akunGrup o ")
	List<Map<String,Object>> findAllAkun();
	
	Akun findById(String id);

}
