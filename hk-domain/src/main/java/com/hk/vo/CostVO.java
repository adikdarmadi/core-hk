package com.hk.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * class Cost
 * 
 * @author Generator
 */
public class CostVO {
	

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;
	
	@NotEmpty(message = "Grup ID tidak boleh kosong")
	private String grupId;
	
	@NotNull(message = "Saldo Awal tidak boleh kosong")
	private BigDecimal saldoAwal;

	@NotNull(message = "Tanggal Awal tidak boleh kosong")
	private Date tglAwal;
	
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

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getGrupId() {
		return grupId;
	}

	public void setGrupId(String grupId) {
		this.grupId = grupId;
	}

	public BigDecimal getSaldoAwal() {
		return saldoAwal;
	}

	public void setSaldoAwal(BigDecimal saldoAwal) {
		this.saldoAwal = saldoAwal;
	}

	public Date getTglAwal() {
		return tglAwal;
	}

	public void setTglAwal(Date tglAwal) {
		this.tglAwal = tglAwal;
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