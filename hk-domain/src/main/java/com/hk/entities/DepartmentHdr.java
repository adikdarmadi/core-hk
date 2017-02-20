package com.hk.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
*
* @author Adhityarismawan
*/

@Entity
@Table(name = "M_DEPARTMENT_HDR")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DepartmentHdr extends BaseModel{

	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "DEPARTMENT_HDR_ID", nullable = false,length=50)
	private String id;
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=100)
	private String nama;

	@NotEmpty(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departmentHdr", cascade = CascadeType.ALL)
	private List<DepartmentDtl> listDepartmentDtl = new ArrayList<DepartmentDtl>();

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

	public List<DepartmentDtl> getListDepartmentDtl() {
		return listDepartmentDtl;
	}

	public void setListDepartmentDtl(List<DepartmentDtl> listDepartmentDtl) {
		this.listDepartmentDtl = listDepartmentDtl;
	}
	
	
}
