/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "M_PROSPEK_CONTACT")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProspekContact extends BaseModel {
 
	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "PROSPEK_CONTACT_ID", nullable = false,length=50)
	private String id;
	
	@NotNull(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;
	
	@Column(name = "INDEX_COUNT")
	private Integer indexCount;
	
	@NotEmpty(message = "PIC tidak boleh kosong")
	@Column(name = "PIC", nullable = false,length=50)
	private String pic;
	
	@Column(name = "DIVISI",length=50)
	private String divisi;
	
	@Column(name = "DEPARTMENT",length=50)
	private String department;
	
	@NotEmpty(message = "Telepon tidak boleh kosong")
	@Column(name = "TELEPON", nullable = false,length=20)
	private String telepon;
	
	@Column(name = "HP",length=20)
	private String hp;
	
	@Column(name = "FAX",length=20)
	private String fax;
	
	@Column(name = "EMAIL",length=20)
	private String email;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROSPEK_FK")
	private Prospek prospek;

	@Column(name = "PROSPEK_FK", insertable = false, updatable = false)
	private String prospekId;

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

	public Integer getIndexCount() {
		return indexCount;
	}

	public void setIndexCount(Integer indexCount) {
		this.indexCount = indexCount;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDivisi() {
		return divisi;
	}

	public void setDivisi(String divisi) {
		this.divisi = divisi;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Prospek getProspek() {
		return prospek;
	}

	public void setProspek(Prospek prospek) {
		this.prospek = prospek;
	}

	public String getProspekId() {
		return prospekId;
	}

	public void setProspekId(String prospekId) {
		this.prospekId = prospekId;
	}

	

}
