package com.hk.vo;


import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * class Widget
 * 
 * @author Generator
 */
public class WidgetVO {
	

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;
	
	private List<String> roles;
	
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	
	
}