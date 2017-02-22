package com.hk.vo;


import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * class Gudang
 * 
 * @author Generator
 */
public class GudangVO {

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama Tidak Boleh Kosong")
	private String nama;
	
	@NotNull(message = "Alamat tidak boleh null")
	private String alamat;

	@NotNull(message = "Tanggal Awal Stock tidak boleh kosong")
	private Date tglAwalStock;

	@NotNull(message = "Is Booked tidak boleh kosong")
	private Boolean isBooked;
	
	@NotNull(message = "Is Putihkan tidak boleh kosong")
	private Boolean isPutihkan;
	
	@NotEmpty(message = "Gudang Grup tidak boleh kosong")
	private String gudangGrupId;

	private Integer version;
	
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

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Date getTglAwalStock() {
		return tglAwalStock;
	}

	public void setTglAwalStock(Date tglAwalStock) {
		this.tglAwalStock = tglAwalStock;
	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Boolean getIsPutihkan() {
		return isPutihkan;
	}

	public void setIsPutihkan(Boolean isPutihkan) {
		this.isPutihkan = isPutihkan;
	}

	public String getGudangGrupId() {
		return gudangGrupId;
	}

	public void setGudangGrupId(String gudangGrupId) {
		this.gudangGrupId = gudangGrupId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
}