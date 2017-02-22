package com.hk.vo;


import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * class Akun
 * 
 * @author Generator
 */
public class AkunVO {

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama Tidak Boleh Kosong")
	private String nama;

	@NotEmpty(message = "Posisi DK tidak boleh kosong")
	private String positionDk;
	
	@NotNull(message = "Level Akun tidak boleh kosong")
	private Integer levelAkun;
	
	@NotEmpty(message = "Tipe Akun tidak boleh kosong")
	private String tipeAkun;
	
	@NotNull(message = "Saldo Awal tidak boleh kosong")
	private BigDecimal saldoAwal;
	
	@NotNull(message = "Saldo Ytd tidak boleh kosong")
	private BigDecimal saldoYtd;
	
	private String akunParentId;
	
	@NotEmpty(message = "Akun Grup tidak boleh kosong")
	private String akunGrupId;

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

	public String getPositionDk() {
		return positionDk;
	}

	public void setPositionDk(String positionDk) {
		this.positionDk = positionDk;
	}

	public Integer getLevelAkun() {
		return levelAkun;
	}

	public void setLevelAkun(Integer levelAkun) {
		this.levelAkun = levelAkun;
	}

	public String getTipeAkun() {
		return tipeAkun;
	}

	public void setTipeAkun(String tipeAkun) {
		this.tipeAkun = tipeAkun;
	}

	public BigDecimal getSaldoAwal() {
		return saldoAwal;
	}

	public void setSaldoAwal(BigDecimal saldoAwal) {
		this.saldoAwal = saldoAwal;
	}

	public BigDecimal getSaldoYtd() {
		return saldoYtd;
	}

	public void setSaldoYtd(BigDecimal saldoYtd) {
		this.saldoYtd = saldoYtd;
	}

	
	public String getAkunParentId() {
		return akunParentId;
	}

	public void setAkunParentId(String akunParentId) {
		this.akunParentId = akunParentId;
	}

	public String getAkunGrupId() {
		return akunGrupId;
	}

	public void setAkunGrupId(String akunGrupId) {
		this.akunGrupId = akunGrupId;
	}

	
}