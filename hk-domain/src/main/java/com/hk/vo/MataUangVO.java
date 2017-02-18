package com.hk.vo;

import javax.validation.constraints.NotNull;

/**
 * class Produk
 * 
 * @author Generator
 */
public class MataUangVO {
	

	@NotNull(message = "ID Tidak Boleh Kosong")
	private String id;

	private Boolean isActive;

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



	
	
}