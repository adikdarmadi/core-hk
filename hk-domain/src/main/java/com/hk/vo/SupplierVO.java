package com.hk.vo;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * class Supplier
 * 
 * @author Generator
 */
public class SupplierVO {
	

	@NotEmpty(message = "ID tidak boleh kosong")
	private String id;

	private String ul;

	private String barcode;

	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;

	@NotEmpty(message = "Group ID tidak boleh kosong")
	private String groupId;

	@NotEmpty(message = "Alamat tidak boleh kosong")
	private String alamat;

	@NotEmpty(message = "Daerah tidak boleh kosong")
	private String daerah;

	@NotEmpty(message = "Wilayah tidak boleh kosong")
	private String wilayah;

	@NotNull(message = "Lama Bayar tidak boleh kosong")
	private Integer lamaBayar;

	@NotNull(message = "Kode PO tidak boleh kosong")
	private Integer kodePo;

	@NotNull(message = "Saldo Awal tidak boleh kosong")
	private BigDecimal saldoAwal;

	@NotNull(message = "Plafon Rp tidak boleh kosong")
	private BigDecimal plafonRp;

	private String namaPkp;

	private String alamatPkp;

	private String npwp;

	private String bank;

	private String cabang;

	private String atasNama;

	private String noRek;
	
	@NotEmpty(message = "Akun tidak boleh kosong")
	private String akunId;

	@NotEmpty(message = "Mata Uang tidak boleh kosong")
	private String mataUangId;

	@NotEmpty(message="Detail Kontak harus diisi")
	//@Valid
	private List<SupplierContactVO> listSupplierContactVO = new ArrayList<SupplierContactVO>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUl() {
		return ul;
	}

	public void setUl(String ul) {
		this.ul = ul;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getDaerah() {
		return daerah;
	}

	public void setDaerah(String daerah) {
		this.daerah = daerah;
	}

	public String getWilayah() {
		return wilayah;
	}

	public void setWilayah(String wilayah) {
		this.wilayah = wilayah;
	}

	public Integer getLamaBayar() {
		return lamaBayar;
	}

	public void setLamaBayar(Integer lamaBayar) {
		this.lamaBayar = lamaBayar;
	}

	public Integer getKodePo() {
		return kodePo;
	}

	public void setKodePo(Integer kodePo) {
		this.kodePo = kodePo;
	}

	public BigDecimal getSaldoAwal() {
		return saldoAwal;
	}

	public void setSaldoAwal(BigDecimal saldoAwal) {
		this.saldoAwal = saldoAwal;
	}

	public BigDecimal getPlafonRp() {
		return plafonRp;
	}

	public void setPlafonRp(BigDecimal plafonRp) {
		this.plafonRp = plafonRp;
	}

	public String getNamaPkp() {
		return namaPkp;
	}

	public void setNamaPkp(String namaPkp) {
		this.namaPkp = namaPkp;
	}

	public String getAlamatPkp() {
		return alamatPkp;
	}

	public void setAlamatPkp(String alamatPkp) {
		this.alamatPkp = alamatPkp;
	}

	public String getNpwp() {
		return npwp;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCabang() {
		return cabang;
	}

	public void setCabang(String cabang) {
		this.cabang = cabang;
	}

	public String getAtasNama() {
		return atasNama;
	}

	public void setAtasNama(String atasNama) {
		this.atasNama = atasNama;
	}

	public String getNoRek() {
		return noRek;
	}

	public void setNoRek(String noRek) {
		this.noRek = noRek;
	}

	public String getAkunId() {
		return akunId;
	}

	public void setAkunId(String akunId) {
		this.akunId = akunId;
	}

	public String getMataUangId() {
		return mataUangId;
	}

	public void setMataUangId(String mataUangId) {
		this.mataUangId = mataUangId;
	}

	public List<SupplierContactVO> getListSupplierContactVO() {
		return listSupplierContactVO;
	}

	public void setListSupplierContactVO(List<SupplierContactVO> listSupplierContactVO) {
		this.listSupplierContactVO = listSupplierContactVO;
	}
	
	
	
	
}