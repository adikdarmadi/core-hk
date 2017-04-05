package com.hk.vo;


import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * class Role
 * 
 * @author Generator
 */
public class RoleVO {
	

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;
	
	private List<String> widgets;
	
	private List<String> users;
	
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

	public List<String> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<String> widgets) {
		this.widgets = widgets;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	
	
	
}