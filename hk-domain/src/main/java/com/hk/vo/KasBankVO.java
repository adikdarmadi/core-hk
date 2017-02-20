package com.hk.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hk.entities.Akun;
import com.hk.entities.MataUang;

/**
 * class KasBank
 * 
 * @author Generator
 */
public class KasBankVO {
	

	@NotNull(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Deskripsi tidak boleh kosong")
	private String deskripsi;
	
	@NotEmpty(message = "Grup tidak boleh kosong")
	private String groupId;
	
	@NotEmpty(message = "Plafon Kredit tidak boleh kosong")
	private BigDecimal plafonKredit;

	private String bank;
	
	private String cabang;
	
	private String atasNama;
	
	private String noRek;
	
	@NotEmpty(message = "Perlu Password tidak boleh kosong")
	private Boolean perluPassword;
	
	@NotEmpty(message = "Sales Biling tidak boleh kosong")
	private Boolean salesBiling;
	
	@NotEmpty(message = "Saldo Awal tidak boleh kosong")
	private BigDecimal saldoAwal;
	
	@NotEmpty(message = "Kurs tidak boleh kosong")
	private BigDecimal kurs;
	
	@NotEmpty(message = "Saldo Awal Rp tidak boleh kosong")
	private BigDecimal saldoAwalRp;

	private Date tanggalRegistrasi;
	
	@NotEmpty(message = "Mata Uang tidak boleh kosong")
	private String mataUangId;
	
	@NotEmpty(message = "Akun tidak boleh kosong")
	private String akunId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getMataUangId() {
		return mataUangId;
	}

	public void setMataUangId(String mataUangId) {
		this.mataUangId = mataUangId;
	}

	public String getAkunId() {
		return akunId;
	}

	public void setAkunId(String akunId) {
		this.akunId = akunId;
	}

	
	
}