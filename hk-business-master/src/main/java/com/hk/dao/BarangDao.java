package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Barang;

@Repository("BarangDao")
public interface BarangDao extends PagingAndSortingRepository<Barang, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.namaBarangSupplier as namaBarangSupplier,"
			+ "m.quantityKonversi as quantityKonversi, m.stokMinimal as stokMinimal,m.stokMaksimal as stokMaksimal,"
			+ "m.saldoAwal as saldoAwal,m.hargaBeli as hargaBeli,m.hargaJual as hargaJual,concat('1 ',m.unitBesarId,' = ',m.quantityKonversi,' ',m.unitKecilId) as volume,"
			+ "bd.id as barangDivisiId, bd.nama as barangDivisiNama, bg.id as barangGrupId, bg.nama as barangGrupNama,"
			+ "bm.id as barangMerkId, bm.nama as barangMerkNama, bt.id as barangTipeId, bt.nama as barangTipeNama, s.id as supplierId, s.nama as supplierNama,"
			+ "g.id as gudangId, g.nama as gudangNama, a.id as akunId, a.nama as akunNama,"
			+ "m.unitBesarId as unitBesarId,m.unitKecilId as unitKecilId,m.unitJualId as unitJualId,m.unitBeliId as unitBeliId, "
			+ "m.isActive as isActive, m.version as version, m.createBy as createBy, m.createDate as createDate) "
			+ "from Barang m left join m.barangDivisi bd left join m.barangGrup bg left join m.barangMerk bm left join m.barangTipe bt "
			+ "left join m.supplier s left join m.gudang g left join m.akun a ")
	List<Map<String,Object>> findAllBarang();
	
	Barang findById(String id);

}
