package com.hk.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
*
* @author Adhityarismawan
*/

@Entity
@Table(name = "D_INISIAL")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Inisial extends InisialProteksi {
	
	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "INISIAL_ID", nullable=false,length=9)
	private String id;
	
	@Version
	@NotEmpty(message = "Version tidak boleh kosong")
	@Column(name = "VERSION", nullable=false)
	private Integer version;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOK_CURRENCY")
	@NotEmpty(message = "Mata Uang tidak boleh kosong")
	private MataUang mataUang;
	
	@Column(name = "BOOK_CURRENCY", insertable = false, updatable = false)
	private String mataUangId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLIER_FK")
	@NotEmpty(message = "Supplier tidak boleh kosong")
	private Supplier supplier;
	
	@Column(name = "SUPPLIER_FK", insertable = false, updatable = false)
	private String supplierId;
	
	@Column(name = "BOOK_CURRENCY_INDEX")
	private Double bookCurrencyIndex;
	
	@Column(name = "BOOK_START")
	private Date bookStart;
	
	@Column(name = "AR_START")
	private Date arStart;
	
	@Column(name = "AP_START")
	private Date apStart;
	
	@Column(name = "STOCK_WARNING")
	private Boolean stockWarning;	
	
	@Column(name = "PPN_VALUE")
	private Double ppnValue;
	
	@Column(name = "PPH_VALUE")
	private Double pphValue;
	
	@Column(name = "ACC_LR_DITAHAN")
	private String accLrDitahan;
	
	@Column(name = "TOLERANSI")
	@NotNull(message = "Toleransi tidak boleh kosong")
	private Double toleransi;
	
	@Column(name = "IS_MIGRATING")
	@NotNull(message = "Is Migrating tidak boleh kosong")
	private Boolean isMigrating;	
	
	@Column(name = "TGL_SALDO_AWAL")
	@NotNull(message = "Tgl Saldo Awal tidak boleh kosong")
	private Date tglSaldoAwal;
	
	@Column(name = "TGL_STOCK_OPNAME")
	private Date tglStockOpname;
	
	@Column(name = "TOGGLE_STOCK_OPNAME")
	private Boolean toggleStockOpname;
	
	@Column(name = "IS_DEPLOY")
	@NotNull(message = "Is Deploy tidak boleh kosong")
	private Boolean isDeploy;	
	
	@Column(name = "MRU_LIMIT")
	private Integer mruLimit;
	
	@Column(name = "NAMA_PERUSAHAAN")
	private String namaPerusahaan;
	
	@Column(name = "LOGO_PERUSAHAAN")
	private String logoPerusahaan;
	
	@Column(name = "TGL_JTEMPO_EQ_TGL_CAIR_KB_MASUK")
	private Boolean tglJTempoEqTglCairKBMasuk;
	
	@Column(name = "TGL_JTEMPO_EQ_TGL_CAIR_KB_KELUAR")
	private Boolean tglJTempoEqTglCairKBKeluar;
	
	@Column(name = "WS_SERVER_ADDRESS_CELUP")
	private String wsServerAddressCelup;

	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	@Column(name = "LAST_UPDATE_BY",length=50)
	private String lastUpdateBy;
	
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

	public MataUang getMataUang() {
		return mataUang;
	}

	public void setMataUang(MataUang mataUang) {
		this.mataUang = mataUang;
	}

	public String getMataUangId() {
		return mataUangId;
	}

	public void setMataUangId(String mataUangId) {
		this.mataUangId = mataUangId;
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

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	
	
}
