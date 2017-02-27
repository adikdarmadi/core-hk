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
@Table(name = "M_USER_ROLE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserRole {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ROLE_ID")
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
	@JoinColumn(name = "ROLE_FK")
	@NotEmpty(message = "Role tidak boleh kosong")
	private Role role;

	@Column(name = "ROLE_FK", nullable=false, insertable = false, updatable = false)
	private String roleId;

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	
}
