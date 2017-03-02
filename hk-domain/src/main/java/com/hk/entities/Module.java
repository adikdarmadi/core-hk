package com.hk.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "M_MODULE")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Module extends BaseModel{

	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "MODULE_ID", nullable = false,length=50)
	private String id;
	
	@NotNull(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=50)
	private String nama;
	
	@NotEmpty(message = "State tidak boleh kosong")
	@Column(name = "STATE",length=255)
    private String state;
	
	@Column(name = "ICON",length=255)
    private String icon;
	
	@NotEmpty(message = "Status tidak boleh kosong")
	@Column(name = "STATUS",length=1)
    private String status;
	
	@NotNull(message = "Urutan tidak boleh kosong")
	@Column(name = "URUTAN",length=2)
    private Integer urutan;
	
	@NotEmpty(message = "Path Map tidak boleh kosong")
	@Column(name = "PATH_MAP",length=255)
    private String pathMap;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULE_FK")
    private Module moduleParent;
	
	@Column(name = "MODULE_FK", insertable = false, updatable = false)
	private String moduleParentId;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "moduleParent",cascade=CascadeType.ALL)
	private List<Module> listModule = new ArrayList<Module>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module",cascade=CascadeType.ALL)
	private List<AccessUser> listAccessUser = new ArrayList<AccessUser>();
	
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUrutan() {
		return urutan;
	}

	public void setUrutan(Integer urutan) {
		this.urutan = urutan;
	}

	public String getPathMap() {
		return pathMap;
	}

	public void setPathMap(String pathMap) {
		this.pathMap = pathMap;
	}

	public Module getModuleParent() {
		return moduleParent;
	}

	public void setModuleParent(Module moduleParent) {
		this.moduleParent = moduleParent;
	}

	public String getModuleParentId() {
		return moduleParentId;
	}

	public void setModuleParentId(String moduleParentId) {
		this.moduleParentId = moduleParentId;
	}

	public List<Module> getListModule() {
		return listModule;
	}

	public void setListModule(List<Module> listModule) {
		this.listModule = listModule;
	}

	public List<AccessUser> getListAccessUser() {
		return listAccessUser;
	}

	public void setListAccessUser(List<AccessUser> listAccessUser) {
		this.listAccessUser = listAccessUser;
	}

	
	
}
