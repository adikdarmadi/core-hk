package com.hk.vo;


import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * class Inisial
 * 
 * @author Generator
 */
public class InisialVO extends InisialProteksiVO {
	
	@NotEmpty(message = "ID tidak boleh kosong")
	private String id;
	
	@NotNull(message = "Version tidak boleh kosong")
	private Integer version;
	
	@NotEmpty(message = "Mata Uang tidak boleh kosong")
	private String mataUangId;
	
	@NotEmpty(message = "Supplier tidak boleh kosong")
	private String supplierId;
	
	private Double bookCurrencyIndex;
	
	private Date bookStart;
	
	private Date arStart;
	
	private Date apStart;
	
	private Boolean stockWarning;	
	
	private Double ppnValue;
	
	private Double pphValue;
	
	private String accLrDitahan;
	
	@NotNull(message = "Toleransi tidak boleh kosong")
	private Double toleransi;
	
	@NotNull(message = "Is Migrating tidak boleh kosong")
	private Boolean isMigrating;	
	
	@NotNull(message = "Tgl Saldo Awal tidak boleh kosong")
	private Date tglSaldoAwal;
	
	private Date tglStockOpname;
	
	private Boolean toggleStockOpname;
	
	@NotNull(message = "Is Deploy tidak boleh kosong")
	private Boolean isDeploy;	
	
	private Integer mruLimit;
	
	private String namaPerusahaan;
	
	private String logoPerusahaan;
	
	private Boolean tglJTempoEqTglCairKBMasuk;
	
	private Boolean tglJTempoEqTglCairKBKeluar;
	
	private String wsServerAddressCelup;

	private Date defaultTglProteksi;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getMataUangId() {
		return mataUangId;
	}

	public void setMataUangId(String mataUangId) {
		this.mataUangId = mataUangId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public Double getBookCurrencyIndex() {
		return bookCurrencyIndex;
	}

	public void setBookCurrencyIndex(Double bookCurrencyIndex) {
		this.bookCurrencyIndex = bookCurrencyIndex;
	}

	public Date getBookStart() {
		return bookStart;
	}

	public void setBookStart(Date bookStart) {
		this.bookStart = bookStart;
	}

	public Date getArStart() {
		return arStart;
	}

	public void setArStart(Date arStart) {
		this.arStart = arStart;
	}

	public Date getApStart() {
		return apStart;
	}

	public void setApStart(Date apStart) {
		this.apStart = apStart;
	}

	public Boolean getStockWarning() {
		return stockWarning;
	}

	public void setStockWarning(Boolean stockWarning) {
		this.stockWarning = stockWarning;
	}

	public Double getPpnValue() {
		return ppnValue;
	}

	public void setPpnValue(Double ppnValue) {
		this.ppnValue = ppnValue;
	}

	public Double getPphValue() {
		return pphValue;
	}

	public void setPphValue(Double pphValue) {
		this.pphValue = pphValue;
	}

	public String getAccLrDitahan() {
		return accLrDitahan;
	}

	public void setAccLrDitahan(String accLrDitahan) {
		this.accLrDitahan = accLrDitahan;
	}

	public Double getToleransi() {
		return toleransi;
	}

	public void setToleransi(Double toleransi) {
		this.toleransi = toleransi;
	}

	public Boolean getIsMigrating() {
		return isMigrating;
	}

	public void setIsMigrating(Boolean isMigrating) {
		this.isMigrating = isMigrating;
	}

	public Date getTglSaldoAwal() {
		return tglSaldoAwal;
	}

	public void setTglSaldoAwal(Date tglSaldoAwal) {
		this.tglSaldoAwal = tglSaldoAwal;
	}

	public Date getTglStockOpname() {
		return tglStockOpname;
	}

	public void setTglStockOpname(Date tglStockOpname) {
		this.tglStockOpname = tglStockOpname;
	}

	public Boolean getToggleStockOpname() {
		return toggleStockOpname;
	}

	public void setToggleStockOpname(Boolean toggleStockOpname) {
		this.toggleStockOpname = toggleStockOpname;
	}

	public Boolean getIsDeploy() {
		return isDeploy;
	}

	public void setIsDeploy(Boolean isDeploy) {
		this.isDeploy = isDeploy;
	}

	public Integer getMruLimit() {
		return mruLimit;
	}

	public void setMruLimit(Integer mruLimit) {
		this.mruLimit = mruLimit;
	}

	public String getNamaPerusahaan() {
		return namaPerusahaan;
	}

	public void setNamaPerusahaan(String namaPerusahaan) {
		this.namaPerusahaan = namaPerusahaan;
	}

	public String getLogoPerusahaan() {
		return logoPerusahaan;
	}

	public void setLogoPerusahaan(String logoPerusahaan) {
		this.logoPerusahaan = logoPerusahaan;
	}

	public Boolean getTglJTempoEqTglCairKBMasuk() {
		return tglJTempoEqTglCairKBMasuk;
	}

	public void setTglJTempoEqTglCairKBMasuk(Boolean tglJTempoEqTglCairKBMasuk) {
		this.tglJTempoEqTglCairKBMasuk = tglJTempoEqTglCairKBMasuk;
	}

	public Boolean getTglJTempoEqTglCairKBKeluar() {
		return tglJTempoEqTglCairKBKeluar;
	}

	public void setTglJTempoEqTglCairKBKeluar(Boolean tglJTempoEqTglCairKBKeluar) {
		this.tglJTempoEqTglCairKBKeluar = tglJTempoEqTglCairKBKeluar;
	}

	public String getWsServerAddressCelup() {
		return wsServerAddressCelup;
	}

	public void setWsServerAddressCelup(String wsServerAddressCelup) {
		this.wsServerAddressCelup = wsServerAddressCelup;
	}

	public Date getDefaultTglProteksi() {
		return defaultTglProteksi;
	}

	public void setDefaultTglProteksi(Date defaultTglProteksi) {
		this.defaultTglProteksi = defaultTglProteksi;
	}
	
	
	
}