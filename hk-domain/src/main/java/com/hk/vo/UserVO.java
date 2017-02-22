package com.hk.vo;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * class User
 * 
 * @author Generator
 */
public class UserVO {
	

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;
	
	@NotEmpty(message = "Password tidak boleh kosong")
	private String password;
	
	@NotNull(message = "MRU Limit tidak boleh kosong")
	private Integer mruLimit;
	
	@NotNull(message = "Is Create tidak boleh kosong")
	private Boolean isCreate;
	
	@NotNull(message = "Is Update tidak boleh kosong")
	private Boolean isUpdate;
	
	@NotNull(message = "Is Delete tidak boleh kosong")
	private Boolean isDelete;
	
	@NotNull(message = "Is Print tidak boleh kosong")
	private Boolean isPrint;
	
	@NotNull(message = "Is Cancel tidak boleh kosong")
	private Boolean isCancel;
	
	@NotNull(message = "Is Report tidak boleh kosong")
	private Boolean isReport;
	
	@NotNull(message = "Is Supervisor tidak boleh kosong")
	private Boolean isSupervisor;
	
	@NotNull(message = "Is Confirm tidak boleh kosong")
	private Boolean isConfirm;
	
	@NotNull(message = "Is Unconfirm tidak boleh kosong")
	private Boolean isUnconfirm;
	
	@NotNull(message = "Is Superuser tidak boleh kosong")
	private Boolean isSuperuser;

	private String pegawaiId;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getMruLimit() {
		return mruLimit;
	}

	public void setMruLimit(Integer mruLimit) {
		this.mruLimit = mruLimit;
	}

	public Boolean getIsCreate() {
		return isCreate;
	}

	public void setIsCreate(Boolean isCreate) {
		this.isCreate = isCreate;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsPrint() {
		return isPrint;
	}

	public void setIsPrint(Boolean isPrint) {
		this.isPrint = isPrint;
	}

	public Boolean getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(Boolean isCancel) {
		this.isCancel = isCancel;
	}

	public Boolean getIsReport() {
		return isReport;
	}

	public void setIsReport(Boolean isReport) {
		this.isReport = isReport;
	}

	public Boolean getIsSupervisor() {
		return isSupervisor;
	}

	public void setIsSupervisor(Boolean isSupervisor) {
		this.isSupervisor = isSupervisor;
	}

	public Boolean getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(Boolean isConfirm) {
		this.isConfirm = isConfirm;
	}

	public Boolean getIsUnconfirm() {
		return isUnconfirm;
	}

	public void setIsUnconfirm(Boolean isUnconfirm) {
		this.isUnconfirm = isUnconfirm;
	}

	public Boolean getIsSuperuser() {
		return isSuperuser;
	}

	public void setIsSuperuser(Boolean isSuperuser) {
		this.isSuperuser = isSuperuser;
	}

	public String getPegawaiId() {
		return pegawaiId;
	}

	public void setPegawaiId(String pegawaiId) {
		this.pegawaiId = pegawaiId;
	}

	
	
}