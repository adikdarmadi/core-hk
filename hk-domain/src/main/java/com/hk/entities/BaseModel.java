package com.hk.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotEmpty;


@MappedSuperclass
public abstract class BaseModel {
	
	@Version
	@NotEmpty(message = "Version tidak boleh kosong")
	@Column(name = "VERSION", nullable=false)
	private Integer version;
	
	@NotEmpty(message = "Create By tidak boleh kosong")
	@Column(name = "CREATE_BY", nullable = false,length=50)
	private String createBy;
	
	@NotEmpty(message = "Create Date tidak boleh kosong")
	@Column(name = "CREATE_DATE", nullable = false)
	private Date createDate;
	
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	@Column(name = "LAST_UPDATE_BY",length=50)
	private String lastUpdateBy;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	
}
