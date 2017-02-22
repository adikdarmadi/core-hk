package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Pegawai;

@Repository("PegawaiDao")
public interface PegawaiDao extends PagingAndSortingRepository<Pegawai, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.lp as lp,m.alamat as alamat,m.kota as kota,m.tanggalLahir as tanggalLahir,"
			+ "m.noHp as noHp,m.noTelepon as noTelepon,m.email as email,m.agama as agama,m.noKtp as noKtp,m.noSim as noSim,m.divisi as divisi,"
			+ "m.gol as gol,m.status as status,m.mulaiBekerja as mulaiBekerja,m.akhirKontrak as akhirKontrak,m.jabatan as jabatan,"
			+ "m.bank as bank,m.atasNama as atasNama,m.noRekening as noRekening, m.plafonRp as plafonRp,m.gajiPokok as gajiPokok,"
			+ "m.uangJabatan as uangJabatan,m.uangHadir as uangHadir,m.bonus as bonus , m.mataUangId as mataUangId,n.id as akunId,"
			+ "n.nama as akunNama,o.id as departmentId,o.nama as departmentNama, "
			+ "m.isActive as isActive, m.version as version, m.createBy as createBy, m.createDate as createDate) "
			+ "from Pegawai m left join m.akun n left join m.department o ")
	List<Map<String,Object>> findAllPegawai();
	
	Pegawai findById(String id);

}
