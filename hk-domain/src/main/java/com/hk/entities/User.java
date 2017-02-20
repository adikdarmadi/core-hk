/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "M_USER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User extends BaseModel {
	
	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "USER_ID", nullable = false,length=50)
	private String id;
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=50)
	private String nama;
	
	@NotEmpty(message = "Password tidak boleh kosong")
	@Column(name = "PASSWORD", nullable = false,length=50)
	private String password;
	
	@NotEmpty(message = "MRU Limit tidak boleh kosong")
	@Column(name = "MRU_LIMIT", nullable = false,length=3)
	private Integer mruLimit;
	
	@NotEmpty(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;
	
	@NotEmpty(message = "Is Create tidak boleh kosong")
	@Column(name = "IS_CREATE", nullable = false)
	private Boolean isCreate;
	
	@NotEmpty(message = "Is Update tidak boleh kosong")
	@Column(name = "IS_UPDATE", nullable = false)
	private Boolean isUpdate;
	
	@NotEmpty(message = "Is Delete tidak boleh kosong")
	@Column(name = "IS_DELETE", nullable = false)
	private Boolean isDelete;
	
	@NotEmpty(message = "Is Print tidak boleh kosong")
	@Column(name = "IS_PRINT", nullable = false)
	private Boolean isPrint;
	
	@NotEmpty(message = "Is Cancel tidak boleh kosong")
	@Column(name = "IS_CANCEL", nullable = false)
	private Boolean isCancel;
	
	@NotEmpty(message = "Is Report tidak boleh kosong")
	@Column(name = "IS_REPORT", nullable = false)
	private Boolean isReport;
	
	@NotEmpty(message = "Is Supervisor tidak boleh kosong")
	@Column(name = "IS_SUPERVISOR", nullable = false)
	private Boolean isSupervisor;
	
	@NotEmpty(message = "Is Confirm tidak boleh kosong")
	@Column(name = "IS_CONFIRM", nullable = false)
	private Boolean isConfirm;
	
	@NotEmpty(message = "Is Unconfirm tidak boleh kosong")
	@Column(name = "IS_UNCONFIRM", nullable = false)
	private Boolean isUnconfirm;
	
	@NotEmpty(message = "Is Superuser tidak boleh kosong")
	@Column(name = "IS_SUPERUSER", nullable = false)
	private Boolean isSuperuser;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PEGAWAI_FK")
	private Pegawai pegawai;

	@Column(name = "PEGAWAI_FK", insertable = false, updatable = false)
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

	public Pegawai getPegawai() {
		return pegawai;
	}

	public void setPegawai(Pegawai pegawai) {
		this.pegawai = pegawai;
	}

	public String getPegawaiId() {
		return pegawaiId;
	}

	public void setPegawaiId(String pegawaiId) {
		this.pegawaiId = pegawaiId;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user", cascade=CascadeType.ALL)
	private Set<AccessUser> accessUserSet=new HashSet<AccessUser>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user", cascade=CascadeType.ALL)
	private Set<UserRole> userRoleSet=new HashSet<UserRole>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user", cascade=CascadeType.ALL)
	private Set<UserGudang> userGudangSet=new HashSet<UserGudang>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user", cascade=CascadeType.ALL)
	private Set<UserKasBank> userKasBankSet=new HashSet<UserKasBank>();*/
	
	
}	
