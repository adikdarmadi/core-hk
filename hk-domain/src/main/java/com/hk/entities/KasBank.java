/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;

import java.io.Serializable;
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
@Table(name = "M_KAS_BANK")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class KasBank extends BaseModel {
 
	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "KAS_BANK_ID", nullable = false,length=50)
	private String id;
	
	@NotNull(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;
	
	@NotEmpty(message = "Deskripsi tidak boleh kosong")
	@Column(name = "DESKRIPSI", nullable = false,length=100)
	private String deskripsi;
	
	@NotEmpty(message = "Grup tidak boleh kosong")
	@Column(name = "GROUP_ID", nullable = false,length=50)
	private String groupId;
	
	@NotNull(message = "Plafon Kredit tidak boleh kosong")
	@Column(name = "PLAFON_KREDIT", nullable = false)
	private BigDecimal plafonKredit;

	@Column(name = "BANK", length=100)
	private String bank;
	
	@Column(name = "CABANG",length=50)
	private String cabang;
	
	@Column(name = "ATAS_NAMA",length=100)
	private String atasNama;
	
	@Column(name = "NO_REK",length=50)
	private String noRek;
	
	@NotNull(message = "Perlu Password tidak boleh kosong")
	@Column(name = "PERLU_PASSWORD", nullable = false)
	private Boolean perluPassword;
	
	@NotNull(message = "Sales Biling tidak boleh kosong")
	@Column(name = "SALES_BILING", nullable = false)
	private Boolean salesBiling;
	
	@NotNull(message = "Saldo Awal tidak boleh kosong")
	@Column(name = "SALDO_AWAL", nullable = false)
	private BigDecimal saldoAwal;
	
	@NotNull(message = "Kurs tidak boleh kosong")
	@Column(name = "KURS", nullable = false)
	private BigDecimal kurs;
	
	@NotNull(message = "Saldo Awal Rp tidak boleh kosong")
	@Column(name = "SALDO_AWAL_RP", nullable = false)
	private BigDecimal saldoAwalRp;

	@Column(name ="TANGGAL_REGISTRASI")
	private Date tanggalRegistrasi;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATA_UANG_FK")
	@NotEmpty(message = "Mata Uang tidak boleh kosong")
	private MataUang mataUang;

	@Column(name = "MATA_UANG_FK", nullable=false, insertable = false, updatable = false)
	private String mataUangId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AKUN_FK")
	@NotEmpty(message = "Akun tidak boleh kosong")
	private Akun akun;

	@Column(name = "AKUN_FK", nullable=false, insertable = false, updatable = false)
	private String akunId;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kasBank", cascade=CascadeType.ALL)
	private List<UserKasBank> listUserKasBank=new ArrayList<UserKasBank>();
	
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

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public BigDecimal getPlafonKredit() {
		return plafonKredit;
	}

	public void setPlafonKredit(BigDecimal plafonKredit) {
		this.plafonKredit = plafonKredit;
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

	public Boolean getPerluPassword() {
		return perluPassword;
	}

	public void setPerluPassword(Boolean perluPassword) {
		this.perluPassword = perluPassword;
	}

	public Boolean getSalesBiling() {
		return salesBiling;
	}

	public void setSalesBiling(Boolean salesBiling) {
		this.salesBiling = salesBiling;
	}

	public BigDecimal getSaldoAwal() {
		return saldoAwal;
	}

	public void setSaldoAwal(BigDecimal saldoAwal) {
		this.saldoAwal = saldoAwal;
	}

	public BigDecimal getKurs() {
		return kurs;
	}

	public void setKurs(BigDecimal kurs) {
		this.kurs = kurs;
	}

	public BigDecimal getSaldoAwalRp() {
		return saldoAwalRp;
	}

	public void setSaldoAwalRp(BigDecimal saldoAwalRp) {
		this.saldoAwalRp = saldoAwalRp;
	}

	public Date getTanggalRegistrasi() {
		return tanggalRegistrasi;
	}

	public void setTanggalRegistrasi(Date tanggalRegistrasi) {
		this.tanggalRegistrasi = tanggalRegistrasi;
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

	public Date getDateNonActive() {
		return dateNonActive;
	}

	public void setDateNonActive(Date dateNonActive) {
		this.dateNonActive = dateNonActive;
	}

	public List<UserKasBank> getListUserKasBank() {
		return listUserKasBank;
	}

	public void setListUserKasBank(List<UserKasBank> listUserKasBank) {
		this.listUserKasBank = listUserKasBank;
	}
	
	
	
}
