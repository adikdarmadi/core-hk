package com.hk.vo;


import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * class Role
 * 
 * @author Generator
 */
public class BarangVO {
	
	@NotEmpty(message = "ID tidak boleh kosong")
	private String id;
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;
	
	private String namaBarangSupplier;
	
	@NotNull(message = "Qty Konversi tidak boleh kosong")
	private Integer quantityKonversi;
	
	@NotNull(message = "Stok Minimal tidak boleh kosong")
	private Integer stokMinimal;
	
	@NotNull(message = "Stok Maksimal tidak boleh kosong")
	private Integer stokMaksimal;
	
	@NotNull(message = "Saldo Awal tidak boleh kosong")
	private BigDecimal saldoAwal;
	
	@NotNull(message = "Harga Beli tidak boleh kosong")
	private BigDecimal hargaBeli;
	
	@NotNull(message = "Harga Jual tidak boleh kosong")
	private BigDecimal hargaJual;

	@NotEmpty(message = "Divisi tidak boleh kosong")
	private String barangDivisiId;
	
	@NotEmpty(message = "Grup tidak boleh kosong")
	private String barangGrupId;
	
	@NotEmpty(message = "Merk tidak boleh kosong")
	private String barangMerkId;
	
	@NotEmpty(message = "Supplier tidak boleh kosong")
	private String supplierId;
	
	@NotEmpty(message = "Gudang tidak boleh kosong")
	private String gudangId;
	
	@NotEmpty(message = "Unit Besar tidak boleh kosong")
	private String unitBesarId;
	
	@NotEmpty(message = "Unit Kecil tidak boleh kosong")
	private String unitKecilId;
	
	@NotEmpty(message = "Akun tidak boleh kosong")
	private String akunId;

	@NotEmpty(message = "Unit Jual tidak boleh kosong")
	private String unitJualId;
	
	@NotEmpty(message = "Unit Beli tidak boleh kosong")
	private String unitBeliId;

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

	public String getBarangDivisiId() {
		return barangDivisiId;
	}

	public void setBarangDivisiId(String barangDivisiId) {
		this.barangDivisiId = barangDivisiId;
	}

	public String getBarangGrupId() {
		return barangGrupId;
	}

	public void setBarangGrupId(String barangGrupId) {
		this.barangGrupId = barangGrupId;
	}

	public String getBarangMerkId() {
		return barangMerkId;
	}

	public void setBarangMerkId(String barangMerkId) {
		this.barangMerkId = barangMerkId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getGudangId() {
		return gudangId;
	}

	public void setGudangId(String gudangId) {
		this.gudangId = gudangId;
	}

	public String getUnitBesarId() {
		return unitBesarId;
	}

	public void setUnitBesarId(String unitBesarId) {
		this.unitBesarId = unitBesarId;
	}

	public String getUnitKecilId() {
		return unitKecilId;
	}

	public void setUnitKecilId(String unitKecilId) {
		this.unitKecilId = unitKecilId;
	}

	public String getAkunId() {
		return akunId;
	}

	public void setAkunId(String akunId) {
		this.akunId = akunId;
	}

	public String getUnitJualId() {
		return unitJualId;
	}

	public void setUnitJualId(String unitJualId) {
		this.unitJualId = unitJualId;
	}

	public String getUnitBeliId() {
		return unitBeliId;
	}

	public void setUnitBeliId(String unitBeliId) {
		this.unitBeliId = unitBeliId;
	}
	
	
}