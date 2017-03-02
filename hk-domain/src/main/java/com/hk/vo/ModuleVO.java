package com.hk.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * class Module
 * 
 * @author Generator
 */
public class ModuleVO {
	

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;
	
	@NotEmpty(message = "State tidak boleh kosong")
    private String state;
	
    private String icon;
	
	@NotEmpty(message = "Status tidak boleh kosong")
    private String status;
	
	@NotNull(message = "Urutan tidak boleh kosong")
    private Integer urutan;
	
	@NotEmpty(message = "Path Map tidak boleh kosong")
	private String pathMap;
	
	private String moduleParentId;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUrutan() {
		return urutan;
	}

	public void setUrutan(Integer urutan) {
		this.urutan = urutan;
	}
	
	public String getPathMap() {
		return pathMap;
	}

	public void setPathMap(String pathMap) {
		this.pathMap = pathMap;
	}

	public String getModuleParentId() {
		return moduleParentId;
	}

	public void setModuleParentId(String moduleParentId) {
		this.moduleParentId = moduleParentId;
	}
	
}