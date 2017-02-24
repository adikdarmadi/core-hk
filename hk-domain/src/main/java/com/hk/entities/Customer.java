/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 *
 * @author Adhityarismawan
 */

@Entity
@Table(name = "M_CUSTOMER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer extends BaseModel {
 
	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "CUSTOMER_ID", nullable = false,length=50)
	private String id;
	
	@Column(name = "BARCODE")
	private String barcode;
	
	@NotEmpty(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=100)
	private String nama;
	
	@NotEmpty(message = "Alamat tidak boleh kosong")
	@Column(name = "ALAMAT", nullable = false)
	private String alamat;
	
	@NotEmpty(message = "Daerah tidak boleh kosong")
	@Column(name = "DAERAH", nullable = false,length=50)
	private String daerah;
	
	@NotEmpty(message = "Kode Pos tidak boleh kosong")
	@Column(name = "KODE_POS", nullable = false,length=50)
	private String kodePos;
	
	@NotEmpty(message = "Kota tidak boleh kosong")
	@Column(name = "KOTA", nullable = false,length=50)
	private String kota;
	
	@NotEmpty(message = "Provinsi tidak boleh kosong")
	@Column(name = "PROVINSI", nullable = false,length=50)
	private String provinsi;
	
	@NotEmpty(message = "Grup ID tidak boleh kosong")
	@Column(name = "GRUP_ID", nullable = false,length=50)
	private String grupId;
	
	@NotEmpty(message = "Tipe ID tidak boleh kosong")
	@Column(name = "TIPE_ID", nullable = false,length=50)
	private String tipeId;
	
	@NotEmpty(message = "Kategori ID tidak boleh kosong")
	@Column(name = "KATEGORI_ID", nullable = false,length=50)
	private String kategoriId;
	
	@NotNull(message = "Saldo Awal tidak boleh kosong")
	@Column(name = "SALDO_AWAL", nullable = false)
	private BigDecimal saldoAwal;

	@NotNull(message = "Plafon Rp tidak boleh kosong")
	@Column(name = "PLAFON_RP", nullable = false)
	private BigDecimal plafonRp;
	
	@NotNull(message = "Plafon Faktur tidak boleh kosong")
	@Column(name = "PLAFON_FAKTUR", nullable = false)
	private BigDecimal plafonFaktur; 
	
	@NotNull(message = "Lama Bayar tidak boleh kosong")
	@Column(name = "LAMA_BAYAR", nullable = false,length=3)
	private Integer lamaBayar;
	
	@NotNull(message = "Hari Tagih tidak boleh kosong")
	@Column(name = "HARI_TAGIH", nullable = false,length=10)
	private String hariTagih;
	
	@NotNull(message = "Nama Di Faktur tidak boleh kosong")
	@Column(name = "NAMA_DI_FAKTUR", nullable = false,length=50)
	private String namaFaktur;
	
	@Column(name = "NAMA_PKP",length=50)
	private String namaPkp;
	
	@Column(name = "ALAMAT_PKP",length=255)
	private String alamatPkp;
	
	@Column(name = "NPWP",length=50)
	private String npwp;
	
	@Column(name = "PEMILIK",length=50)
	private String pemilik;
	
	@Column(name = "TANGGAL_LAHIR")
	private Date tanggalLahir;
	
	@Column(name = "HARI_RAYA",length=30)
	private String hariRaya;
	
	@Column(name = "STATUS_PROPERTY",length=10)
	private String statusProperty;
	
	@Column(name = "TANGGAL_DIDIRIKAN")
	private Date tanggalDidirikan;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SALES_FK")
	@NotEmpty(message = "Follow Up / Sales tidak boleh kosong")
	private Sales sales;

	@Column(name = "SALES_FK",nullable = false, insertable = false, updatable = false)
	private String salesId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROSPEK_FK")
	@NotEmpty(message = "Prospek tidak boleh kosong")
	private Prospek prospek;

	@Column(name = "PROSPEK_FK",nullable = false, insertable = false, updatable = false)
	private String prospekId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KAS_BANK_FK")
	@NotEmpty(message = "Kas Bank tidak boleh kosong")
	private KasBank kasBank;

	@Column(name = "KAS_BANK_FK",nullable = false, insertable = false, updatable = false)
	private String kasBankId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AKUN_FK")
	@NotEmpty(message = "Akun tidak boleh kosong")
	private Akun akun;

	@Column(name = "AKUN_FK",nullable = false, insertable = false, updatable = false)
	private String akunId;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<CustomerContact> listCustomerContact = new ArrayList<CustomerContact>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDateNonActive() {
		return dateNonActive;
	}

	public void setDateNonActive(Date dateNonActive) {
		this.dateNonActive = dateNonActive;
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

	public BigDecimal getPlafonFaktur() {
		return plafonFaktur;
	}

	public void setPlafonFaktur(BigDecimal plafonFaktur) {
		this.plafonFaktur = plafonFaktur;
	}

	public Integer getLamaBayar() {
		return lamaBayar;
	}

	public void setLamaBayar(Integer lamaBayar) {
		this.lamaBayar = lamaBayar;
	}

	public String getHariTagih() {
		return hariTagih;
	}

	public void setHariTagih(String hariTagih) {
		this.hariTagih = hariTagih;
	}

	public String getNamaFaktur() {
		return namaFaktur;
	}

	public void setNamaFaktur(String namaFaktur) {
		this.namaFaktur = namaFaktur;
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

	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public String getSalesId() {
		return salesId;
	}

	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	public Prospek getProspek() {
		return prospek;
	}

	public void setProspek(Prospek prospek) {
		this.prospek = prospek;
	}

	public String getProspekId() {
		return prospekId;
	}

	public void setProspekId(String prospekId) {
		this.prospekId = prospekId;
	}

	public KasBank getKasBank() {
		return kasBank;
	}

	public void setKasBank(KasBank kasBank) {
		this.kasBank = kasBank;
	}

	public String getKasBankId() {
		return kasBankId;
	}

	public void setKasBankId(String kasBankId) {
		this.kasBankId = kasBankId;
	}

	public Akun getAkun() {
		return akun;
	}

	public void setAkun(Akun akun) {
		this.akun = akun;
	}

	public String getAkunId() {
		return akunId;
	}

	public void setAkunId(String akunId) {
		this.akunId = akunId;
	}

	public List<CustomerContact> getListCustomerContact() {
		return listCustomerContact;
	}

	public void setListCustomerContact(List<CustomerContact> listCustomerContact) {
		this.listCustomerContact = listCustomerContact;
	}

	
}
