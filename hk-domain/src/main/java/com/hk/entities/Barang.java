/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 *
 * @author Adhityarismawan
 */

@Entity
@Table(name = "M_BARANG")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Barang extends BaseModel {
 
	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "BARANG_ID", nullable = false,length=50)
	private String id;
	
	@NotNull(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;

	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=100)
	private String nama;
	
	@Column(name = "NAMA_BARANG_SUPPLIER",length=100)
	private String namaBarangSupplier;
	
	@NotNull(message = "Qty Konversi tidak boleh kosong")
	@Column(name = "QUANTITY_KONVERSI")
	private Integer quantityKonversi;
	
	@NotNull(message = "Stok Minimal tidak boleh kosong")
	@Column(name = "STOK_MINIMAL")
	private Integer stokMinimal;
	
	@NotNull(message = "Stok Maksimal tidak boleh kosong")
	@Column(name = "STOK_MAKSIMAL")
	private Integer stokMaksimal;
	
	@NotNull(message = "Saldo Awal tidak boleh kosong")
	@Column(name = "SALDO_AWAL")
	private BigDecimal saldoAwal;
	
	@NotNull(message = "Harga Beli tidak boleh kosong")
	@Column(name = "HARGA_BELI")
	private BigDecimal hargaBeli;
	
	@NotNull(message = "Harga Jual tidak boleh kosong")
	@Column(name = "HARGA_JUAL")
	private BigDecimal hargaJual;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BARANG_DIVISI_FK")
	@NotEmpty(message = "Divisi tidak boleh kosong")
	private BarangDivisi barangDivisi;

	@Column(name = "BARANG_DIVISI_FK",nullable=false, insertable = false, updatable = false)
	private String barangDivisiId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BARANG_GRUP_FK")
	@NotEmpty(message = "Grup tidak boleh kosong")
	private BarangGrup barangGrup;

	@Column(name = "BARANG_GRUP_FK",nullable=false, insertable = false, updatable = false)
	private String barangGrupId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BARANG_MERK_FK")
	@NotEmpty(message = "Merk tidak boleh kosong")
	private BarangMerk barangMerk;

	@Column(name = "BARANG_MERK_FK",nullable=false, insertable = false, updatable = false)
	private String barangMerkId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BARANG_TIPE_FK")
	@NotEmpty(message = "Tipe tidak boleh kosong")
	private BarangTipe barangTipe;

	@Column(name = "BARANG_TIPE_FK",nullable=false, insertable = false, updatable = false)
	private String barangTipeId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLIER_FK")
	@NotEmpty(message = "Supplier tidak boleh kosong")
	private Supplier supplier;

	@Column(name = "SUPPLIER_FK",nullable=false, insertable = false, updatable = false)
	private String supplierId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GUDANG_FK")
	@NotEmpty(message = "Gudang tidak boleh kosong")
	private Gudang gudang;

	@Column(name = "GUDANG_FK",nullable=false, insertable = false, updatable = false)
	private String gudangId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_BESAR_FK")
	@NotEmpty(message = "Unit Besar tidak boleh kosong")
	private Unit unitBesar;

	@Column(name = "UNIT_BESAR_FK",nullable=false, insertable = false, updatable = false)
	private String unitBesarId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_KECIL_FK")
	@NotEmpty(message = "Unit Kecil tidak boleh kosong")
	private Unit unitKecil;

	@Column(name = "UNIT_KECIL_FK",nullable=false, insertable = false, updatable = false)
	private String unitKecilId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AKUN_FK")
	@NotEmpty(message = "Akun tidak boleh kosong")
	private Akun akun;

	@Column(name = "AKUN_FK",nullable=false, insertable = false, updatable = false)
	private String akunId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_JUAL_FK")
	@NotEmpty(message = "Unit Jual tidak boleh kosong")
	private Unit unitJual;

	@Column(name = "UNIT_JUAL_FK",nullable=false, insertable = false, updatable = false)
	private String unitJualId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_BELI_FK")
	@NotEmpty(message = "Unit Beli tidak boleh kosong")
	private Unit unitBeli;

	@Column(name = "UNIT_BELI_FK",nullable=false, insertable = false, updatable = false)
	private String unitBeliId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getNamaBarangSupplier() {
		return namaBarangSupplier;
	}

	public void setNamaBarangSupplier(String namaBarangSupplier) {
		this.namaBarangSupplier = namaBarangSupplier;
	}

	public Integer getQuantityKonversi() {
		return quantityKonversi;
	}

	public void setQuantityKonversi(Integer quantityKonversi) {
		this.quantityKonversi = quantityKonversi;
	}

	public Integer getStokMinimal() {
		return stokMinimal;
	}

	public void setStokMinimal(Integer stokMinimal) {
		this.stokMinimal = stokMinimal;
	}

	public Integer getStokMaksimal() {
		return stokMaksimal;
	}

	public void setStokMaksimal(Integer stokMaksimal) {
		this.stokMaksimal = stokMaksimal;
	}

	public BigDecimal getSaldoAwal() {
		return saldoAwal;
	}

	public void setSaldoAwal(BigDecimal saldoAwal) {
		this.saldoAwal = saldoAwal;
	}

	public BigDecimal getHargaBeli() {
		return hargaBeli;
	}

	public void setHargaBeli(BigDecimal hargaBeli) {
		this.hargaBeli = hargaBeli;
	}

	public BigDecimal getHargaJual() {
		return hargaJual;
	}

	public void setHargaJual(BigDecimal hargaJual) {
		this.hargaJual = hargaJual;
	}

	public BarangDivisi getBarangDivisi() {
		return barangDivisi;
	}

	public void setBarangDivisi(BarangDivisi barangDivisi) {
		this.barangDivisi = barangDivisi;
	}

	public String getBarangDivisiId() {
		return barangDivisiId;
	}

	public void setBarangDivisiId(String barangDivisiId) {
		this.barangDivisiId = barangDivisiId;
	}

	public BarangGrup getBarangGrup() {
		return barangGrup;
	}

	public void setBarangGrup(BarangGrup barangGrup) {
		this.barangGrup = barangGrup;
	}

	public String getBarangGrupId() {
		return barangGrupId;
	}

	public void setBarangGrupId(String barangGrupId) {
		this.barangGrupId = barangGrupId;
	}

	public BarangMerk getBarangMerk() {
		return barangMerk;
	}

	public void setBarangMerk(BarangMerk barangMerk) {
		this.barangMerk = barangMerk;
	}

	public String getBarangMerkId() {
		return barangMerkId;
	}

	public void setBarangMerkId(String barangMerkId) {
		this.barangMerkId = barangMerkId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public Gudang getGudang() {
		return gudang;
	}

	public void setGudang(Gudang gudang) {
		this.gudang = gudang;
	}

	public String getGudangId() {
		return gudangId;
	}

	public void setGudangId(String gudangId) {
		this.gudangId = gudangId;
	}

	public Unit getUnitBesar() {
		return unitBesar;
	}

	public void setUnitBesar(Unit unitBesar) {
		this.unitBesar = unitBesar;
	}

	public String getUnitBesarId() {
		return unitBesarId;
	}

	public void setUnitBesarId(String unitBesarId) {
		this.unitBesarId = unitBesarId;
	}

	public Unit getUnitKecil() {
		return unitKecil;
	}

	public void setUnitKecil(Unit unitKecil) {
		this.unitKecil = unitKecil;
	}

	public String getUnitKecilId() {
		return unitKecilId;
	}

	public void setUnitKecilId(String unitKecilId) {
		this.unitKecilId = unitKecilId;
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

	public Unit getUnitJual() {
		return unitJual;
	}

	public void setUnitJual(Unit unitJual) {
		this.unitJual = unitJual;
	}

	public String getUnitJualId() {
		return unitJualId;
	}

	public void setUnitJualId(String unitJualId) {
		this.unitJualId = unitJualId;
	}

	public Unit getUnitBeli() {
		return unitBeli;
	}

	public void setUnitBeli(Unit unitBeli) {
		this.unitBeli = unitBeli;
	}

	public String getUnitBeliId() {
		return unitBeliId;
	}

	public void setUnitBeliId(String unitBeliId) {
		this.unitBeliId = unitBeliId;
	}

	public BarangTipe getBarangTipe() {
		return barangTipe;
	}

	public void setBarangTipe(BarangTipe barangTipe) {
		this.barangTipe = barangTipe;
	}

	public String getBarangTipeId() {
		return barangTipeId;
	}

	public void setBarangTipeId(String barangTipeId) {
		this.barangTipeId = barangTipeId;
	}
	
	
	/*@ManyToOne
	@JoinColumn(name = "MATA_UANG_BELI_FK")
	private MataUang mataUangBeli;

	@Column(name = "MATA_UANG_BELI_FK", insertable = false, updatable = false)
	private String mataUangBeliId;
	
	@ManyToOne
	@JoinColumn(name = "MATA_UANG_JUAL_FK")
	private MataUang mataUangJual;

	@Column(name = "MATA_UANG_JUAL_FK", insertable = false, updatable = false)
	private String mataUangJualId;*/
	
	
	
}
