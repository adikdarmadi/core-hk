/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OptimisticLockType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 *
 * @author Adik
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "M_MATA_UANG")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MataUang {
 
	@Id
	@Column(name = "MATA_UANG_ID")
	private String id;
	
	@Column(name = "IS_ACTIVE")
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
