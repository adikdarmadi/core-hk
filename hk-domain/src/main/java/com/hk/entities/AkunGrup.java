package com.hk.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "M_AKUN_GRUP")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AkunGrup extends BaseModel {

	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "AKUN_GRUP_ID", nullable = false,length=50)
	private String id;
	
	@NotEmpty(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=50)
    private String nama;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "akunGrup",cascade=CascadeType.ALL)
	private List<Akun> listAkun = new ArrayList<Akun>();

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

	public Date getDateNonActive() {
		return dateNonActive;
	}

	public void setDateNonActive(Date dateNonActive) {
		this.dateNonActive = dateNonActive;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public List<Akun> getListAkun() {
		return listAkun;
	}

	public void setListAkun(List<Akun> listAkun) {
		this.listAkun = listAkun;
	}

	
}
