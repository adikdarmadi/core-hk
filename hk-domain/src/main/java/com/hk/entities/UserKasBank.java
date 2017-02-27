/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 *
 * @author Adhityarismawan
 */

@Entity
@Table(name = "M_USER_KAS_BANK")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserKasBank {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_KAS_BANK_ID")
	private Integer id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_FK")
	@NotEmpty(message = "User tidak boleh kosong")
	private User user;

	@Column(name = "USER_FK", nullable=false, insertable = false, updatable = false)
	private String userId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KAS_BANK_FK")
	@NotEmpty(message = "Kas Bank tidak boleh kosong")
	private KasBank kasBank;

	@Column(name = "KAS_BANK_FK", nullable=false, insertable = false, updatable = false)
	private String kasBankId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public KasBank getKasBank() {
		return kasBank;
	}

	public void setKasBank(KasBank kasBank) {
		this.kasBank = kasBank;
	}

	public String getKasBankId() {
		return kasBankId;
	}

	public void setKasBankId(String kasBankId) {
		this.kasBankId = kasBankId;
	}

}
