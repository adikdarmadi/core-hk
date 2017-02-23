/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Adhityarismawan
 */

@Entity
@Table(name = "M_SUPPLIER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Supplier extends BaseModel{

	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "SUPPLIER_ID", nullable = false,length=50)
	private String id;

	@NotNull(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;

	@Column(name = "UL",length=50)
	private String ul;

	@Column(name = "BARCODE",length=50)
	private String barcode;

	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=50)
	private String nama;

	@NotEmpty(message = "Group ID tidak boleh kosong")
	@Column(name = "GROUP_ID", nullable = false,length=50)
	private String groupId;

	@NotEmpty(message = "Alamat tidak boleh kosong")
	@Column(name = "ALAMAT", nullable = false,length=50)
	private String alamat;

	@NotEmpty(message = "Daerah tidak boleh kosong")
	@Column(name = "DAERAH", nullable = false,length=50)
	private String daerah;

	@NotEmpty(message = "Wilayah tidak boleh kosong")
	@Column(name = "WILAYAH", nullable = false,length=50)
	private String wilayah;

	@NotNull(message = "Lama Bayar tidak boleh kosong")
	@Column(name = "LAMA_BAYAR", nullable = false,length=3)
	private Integer lamaBayar;

	@NotNull(message = "Kode PO tidak boleh kosong")
	@Column(name = "KODE_PO", nullable = false,length=3)
	private Integer kodePo;

	@NotNull(message = "Saldo Awal tidak boleh kosong")
	@Column(name = "SALDO_AWAL", nullable = false)
	private BigDecimal saldoAwal;

	@NotNull(message = "Plafon Rp tidak boleh kosong")
	@Column(name = "PLAFON_RP", nullable = false)
	private BigDecimal plafonRp;

	@Column(name = "NAMA_PKP",length=50)
	private String namaPkp;

	@Column(name = "ALAMAT_PKP",length=255)
	private String alamatPkp;

	@Column(name = "NPWP",length=50)
	private String npwp;

	@Column(name = "BANK",length=50)
	private String bank;

	@Column(name = "CABANG",length=50)
	private String cabang;

	@Column(name = "ATAS_NAMA",length=50)
	private String atasNama;

	@Column(name = "NOREK",length=30)
	private String noRek;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACC_UM_ID")
	@NotEmpty(message = "Akun tidak boleh kosong")
	private Akun akun;

	@Column(name = "ACC_UM_ID", nullable=false, insertable = false, updatable = false)
	private String akunId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATA_UANG_FK")
	@NotEmpty(message = "Mata Uang tidak boleh kosong")
	private MataUang mataUang;

	@Column(name = "MATA_UANG_FK", nullable=false, insertable = false, updatable = false)
	private String mataUangId;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", cascade = CascadeType.ALL)
	private List<SupplierContact> listSupplierContact = new ArrayList<SupplierContact>();

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

	public List<SupplierContact> getListSupplierContact() {
		return listSupplierContact;
	}

	public void setListSupplierContact(List<SupplierContact> listSupplierContact) {
		this.listSupplierContact = listSupplierContact;
	}
	
	

}
