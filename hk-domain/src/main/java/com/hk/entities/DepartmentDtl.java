package com.hk.entities;

import java.io.Serializable;
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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Adhityarismawan
 */

@Entity
@Table(name = "M_DEPARTMENT_DTL")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DepartmentDtl extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTMENT_DTL_ID")
	private Integer id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_HDR_FK")
	@NotEmpty(message = "Department Hdr tidak boleh kosong")
	private DepartmentHdr departmentHdr;

	@Column(name = "DEPARTMENT_HDR_FK", nullable = false, insertable = false, updatable = false)
	private String departmentHdrId;

	@NotEmpty(message = "Shift tidak boleh kosong")
	@Column(name = "SHIFT", nullable = false,length=15)
	private String shift;

	@NotEmpty(message = "Jam Masuk tidak boleh kosong")
	@Column(name = "JAM_MASUK", nullable = false,length=5)
	private String jamMasuk;

	@NotEmpty(message = "Jam Keluar tidak boleh kosong")
	@Column(name = "JAM_KELUAR", nullable = false,length=5)
	private String jamKeluar;

	@NotEmpty(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DepartmentHdr getDepartmentHdr() {
		return departmentHdr;
	}

	public void setDepartmentHdr(DepartmentHdr departmentHdr) {
		this.departmentHdr = departmentHdr;
	}

	public String getDepartmentHdrId() {
		return departmentHdrId;
	}

	public void setDepartmentHdrId(String departmentHdrId) {
		this.departmentHdrId = departmentHdrId;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getJamMasuk() {
		return jamMasuk;
	}

	public void setJamMasuk(String jamMasuk) {
		this.jamMasuk = jamMasuk;
	}

	public String getJamKeluar() {
		return jamKeluar;
	}

	public void setJamKeluar(String jamKeluar) {
		this.jamKeluar = jamKeluar;
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
	
	
}
