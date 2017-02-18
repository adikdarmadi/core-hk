package com.hk.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class DetailKomponenHargaVO {

	@NotEmpty(message="Deskripsi Tidak Boleh Kosong")
	private String deskripsi;

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	
}