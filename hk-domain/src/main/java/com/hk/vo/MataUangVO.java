package com.hk.vo;

import javax.validation.constraints.NotNull;

/**
 * class MataUang
 * 
 * @author Generator
 */
public class MataUangVO {
	

	@NotNull(message = "ID Tidak Boleh Kosong")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}