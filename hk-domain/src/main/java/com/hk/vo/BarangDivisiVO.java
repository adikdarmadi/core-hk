package com.hk.vo;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * class BarangDivisi
 * 
 * @author Generator
 */
public class BarangDivisiVO {
	

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;
	
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

	
	
}