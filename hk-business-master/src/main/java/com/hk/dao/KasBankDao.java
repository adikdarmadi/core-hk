package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.KasBank;

@Repository("KasBankDao")
public interface KasBankDao extends PagingAndSortingRepository<KasBank, String> {

	@Query("select new map (m.id as id,m.deskripsi as deskripsi,m.groupId as groupId,m.plafonKredit as plafonKredit,m.bank as bank,"
			+ "m.cabang as cabang, m.atasNama as atasNama, m.noRek as noRek,m.perluPassword as perluPassword,m.salesBiling as salesBiling, "
			+ "m.saldoAwal as saldoAwal, m.kurs as kurs,m.saldoAwalRp as saldoAwalRp,m.tanggalRegistrasi as tanggalRegistrasi,"
			+ "m.mataUangId as mataUangId,n.id as akunId,n.nama as akunNama , m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from KasBank m left join m.akun n ")
	List<Map<String,Object>> findAllKasBank();
	
	KasBank findById(String id);

	List<KasBank> findByIsActive(Boolean isActive);

}
