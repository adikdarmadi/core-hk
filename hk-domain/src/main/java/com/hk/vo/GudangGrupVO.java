package com.hk.vo;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * class GudangGrup
 * 
 * @author Generator
 */
public class GudangGrupVO {

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama Tidak Boleh Kosong")
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