package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Customer;

@Repository("CustomerDao")
public interface CustomerDao extends PagingAndSortingRepository<Customer, String> {

	@Query("select new map (m.id as id,m.barcode as barcode,m.nama as nama,m.alamat as alamat, m.kodePos as kodePos,"
			+ "m.kota as kota,m.provinsi as provinsi,m.grupId as grupId,m.tipeId as tipeId,m.kategoriId as kategoriId,"
			+ "m.saldoAwal as saldoAwal, m.plafonRp as plafonRp,m.plafonFaktur as plafonFaktur,m.lamaBayar as lamaBayar, "
			+ "m.hariTagih as hariTagih,m.namaFaktur as namaFaktur,m.namaPkp as namaPkp,m.alamatPkp as alamatPkp,"
			+ "m.npwp as npwp,m.pemilik as pemilik,m.tanggalLahir as tanggalLahir,"
			+ "m.hariRaya as hariRaya,m.statusProperty as statusProperty,m.tanggalDidirikan as tanggalDidirikan,"
			+ "s.id as salesId,s.nama as salesNama,"
			+ "m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from Customer m left join m.sales s left join m.prospek p left join m.kasBank k "
			+ "left join m.akun a")
	List<Map<String,Object>> findAllCustomer();
	
	Customer findById(String id);

}
