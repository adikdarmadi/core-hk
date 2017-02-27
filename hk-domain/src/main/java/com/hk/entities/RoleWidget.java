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
@Table(name = "M_ROLE_WIDGET")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RoleWidget {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "M_ROLE_WIDGET_ID")
	private Integer id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_FK")
	@NotEmpty(message = "Role tidak boleh kosong")
	private Role role;

	@Column(name = "ROLE_FK", nullable=false, insertable = false, updatable = false)
	private String roleId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WIDGET_FK")
	@NotEmpty(message = "Widget tidak boleh kosong")
	private Widget widget;

	@Column(name = "WIDGET_FK", nullable=false, insertable = false, updatable = false)
	private String widgetId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Widget getWidget() {
		return widget;
	}

	public void setWidget(Widget widget) {
		this.widget = widget;
	}

	public String getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
	}

	
	
}
