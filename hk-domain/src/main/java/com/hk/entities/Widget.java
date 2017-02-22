package com.hk.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Adhityarismawan
 */

@Entity
@Table(name = "M_WIDGET")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Widget extends BaseModel {

	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "WIDGET_ID", nullable = false,length=50)
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=50)
	private String nama;

	@NotNull(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;

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

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.widget", cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RoleWidget> roleWidgetSet=new HashSet<RoleWidget>();*/
	
	
	
}
