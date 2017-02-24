package com.hk.vo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * class Role
 * 
 * @author Generator
 */
public class ProspekVO {
	

	@NotEmpty(message = "ID tidak boleh kosong")
	private String id;
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;
	
	@NotEmpty(message = "Alamat tidak boleh kosong")
	private String alamat;
	
	@NotEmpty(message = "Daerah tidak boleh kosong")
	private String daerah;
	
	@NotEmpty(message = "Kode Pos tidak boleh kosong")
	private String kodePos;
	
	@NotEmpty(message = "Kota tidak boleh kosong")
	private String kota;
	
	@NotEmpty(message = "Provinsi tidak boleh kosong")
	private String provinsi;
	
	@NotEmpty(message = "Grup ID tidak boleh kosong")
	private String grupId;
	
	@NotEmpty(message = "Tipe ID tidak boleh kosong")
	private String tipeId;
	
	@NotEmpty(message = "Kategori ID tidak boleh kosong")
	private String kategoriId;
	
	private String namaPkp;
	
	private String alamatPkp;
	
	private String npwp;
	
	private String pemilik;
	
	private Date tanggalLahir;
	
	private String hariRaya;
	
	private String statusProperty;
	
	private Date tanggalDidirikan;
	
	@NotEmpty(message = "Follow Up / Sales tidak boleh kosong")
	private String salesId;

	@NotEmpty(message="Detail Kontak harus diisi")
	//@Valid
	private List<ProspekContactVO> listProspekContactVO = new ArrayList<ProspekContactVO>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
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

	public String getKodePos() {
		return kodePos;
	}

	public void setKodePos(String kodePos) {
		this.kodePos = kodePos;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public String getGrupId() {
		return grupId;
	}

	public void setGrupId(String grupId) {
		this.grupId = grupId;
	}

	public String getTipeId() {
		return tipeId;
	}

	public void setTipeId(String tipeId) {
		this.tipeId = tipeId;
	}

	public String getKategoriId() {
		return kategoriId;
	}

	public void setKategoriId(String kategoriId) {
		this.kategoriId = kategoriId;
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

	public String getPemilik() {
		return pemilik;
	}

	public void setPemilik(String pemilik) {
		this.pemilik = pemilik;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getHariRaya() {
		return hariRaya;
	}

	public void setHariRaya(String hariRaya) {
		this.hariRaya = hariRaya;
	}

	public String getStatusProperty() {
		return statusProperty;
	}

	public void setStatusProperty(String statusProperty) {
		this.statusProperty = statusProperty;
	}

	public Date getTanggalDidirikan() {
		return tanggalDidirikan;
	}

	public void setTanggalDidirikan(Date tanggalDidirikan) {
		this.tanggalDidirikan = tanggalDidirikan;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public List<ProspekContactVO> getListProspekContactVO() {
		return listProspekContactVO;
	}

	public void setListProspekContactVO(List<ProspekContactVO> listProspekContactVO) {
		this.listProspekContactVO = listProspekContactVO;
	}
	
	
	
}