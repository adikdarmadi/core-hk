package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Supplier;

@Repository("SupplierDao")
public interface SupplierDao extends PagingAndSortingRepository<Supplier, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.ul as ul,m.barcode as barcode,m.groupId as groupId,m.alamat as alamat, "
			+ "m.daerah as daerah,m.wilayah as wilayah,m.lamaBayar as lamaBayar,m.kodePo as kodePo,m.saldoAwal as saldoAwal,"
			+ "m.plafonRp as plafonRp,m.namaPkp as namaPkp,m.alamatPkp as alamatPkp,m.npwp as npwp,m.bank as bank,m.cabang as cabang,"
			+ "m.atasNama as atasNama,m.noRek as noRek,n.id as akunId,n.nama as akunNama,m.mataUangId as mataUangId,"
			+ "m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from Supplier m left join m.akun n ")
	List<Map<String,Object>> findAllSupplier();
	
	Supplier findById(String id);

}
