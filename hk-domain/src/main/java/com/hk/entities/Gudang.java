/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;

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
@Table(name = "M_GUDANG")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Gudang extends BaseModel {

	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "GUDANG_ID", nullable = false,length=50)
	private String id;
	
	@NotEmpty(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;

	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=50)
	private String nama;

	@NotNull(message = "Alamat tidak boleh null")
	@Column(name = "ALAMAT", nullable = false)
	private String alamat;

	@NotEmpty(message = "Tanggal Awal Stock tidak boleh kosong")
	@Column(name = "TGL_AWAL_STOK", nullable = false)
	private Date tglAwalStock;

	@NotEmpty(message = "Is Booked tidak boleh kosong")
	@Column(name = "IS_BOOKED", nullable = false)
	private Boolean isBooked;
	
	@NotEmpty(message = "Is Putihkan tidak boleh kosong")
	@Column(name = "IS_PUTIHKAN", nullable = false)
	private Boolean isPutihkan;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GUDANG_GRUP_FK")
	@NotEmpty(message = "Gudang Grup tidak boleh kosong")
	private GudangGrup gudangGrup;

	@Column(name = "GUDANG_GRUP_FK", nullable=false, insertable = false, updatable = false)
	private String gudangGrupId;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gudang", cascade=CascadeType.ALL)
	private List<UserGudang> listUserGudang=new ArrayList<UserGudang>();
	
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

	public GudangGrup getGudangGrup() {
		return gudangGrup;
	}

	public void setGudangGrup(GudangGrup gudangGrup) {
		this.gudangGrup = gudangGrup;
	}

	public String getGudangGrupId() {
		return gudangGrupId;
	}

	public void setGudangGrupId(String gudangGrupId) {
		this.gudangGrupId = gudangGrupId;
	}

	public List<UserGudang> getListUserGudang() {
		return listUserGudang;
	}

	public void setListUserGudang(List<UserGudang> listUserGudang) {
		this.listUserGudang = listUserGudang;
	}
	
	
}
