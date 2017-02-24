package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Prospek;

@Repository("ProspekDao")
public interface ProspekDao extends PagingAndSortingRepository<Prospek, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.alamat as alamat, m.daerah as daerah,m.kodePos as kodePos,m.kota as kota,"
			+ "m.provinsi as provinsi,m.grupId as grupId,m.tipeId as tipeId,m.kategoriId as kategoriId,"
			+ "m.namaPkp as namaPkp,m.alamatPkp as alamatPkp,m.npwp as npwp,m.pemilik as pemilik,m.tanggalLahir as tanggalLahir,"
			+ "m.hariRaya as hariRaya,m.statusProperty as statusProperty,m.tanggalDidirikan as tanggalDidirikan,"
			+ "s.id as salesId,s.nama as salesNama,"
			+ "m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from Prospek m left join m.sales s ")
	List<Map<String,Object>> findAllProspek();
	
	Prospek findById(String id);

}
