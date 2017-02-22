/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 *
 * @author Adhityarismawan
 */

@Entity
@Table(name = "M_USER_MRU")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserMRU {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@NotNull(message = "Tanggal Akses tidak boleh kosong")
	@Column(name = "TANGGAL_AKSES", nullable = false)
	private Date tanggalAkses;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_FK")
	@NotEmpty(message = "User tidak boleh kosong")
	private User user;

	@Column(name = "USER_FK", nullable=false, insertable = false, updatable = false)
	private String userId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULE_FK")
	@NotEmpty(message = "Module tidak boleh kosong")
    private Module module;
	
	@Column(name = "MODULE_FK", nullable=false, insertable = false, updatable = false)
	private String moduleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTanggalAkses() {
		return tanggalAkses;
	}

	public void setTanggalAkses(Date tanggalAkses) {
		this.tanggalAkses = tanggalAkses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
	
	

}
