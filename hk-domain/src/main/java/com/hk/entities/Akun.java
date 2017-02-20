package com.hk.entities;

import java.math.BigDecimal;
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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
*
* @author Adhityarismawan
*/

@Entity
@Table(name = "M_AKUN")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Akun extends BaseModel {
	
	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "AKUN_ID", nullable = false,length=50)
	private String id;
	
	@NotEmpty(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=50)
	private String nama;

	@NotEmpty(message = "Posisi DK tidak boleh kosong")
	@Column(name = "POSISI_DK", nullable = false,length=1)
	private String positionDk;

	@NotEmpty(message = "Level Akun tidak boleh kosong")
	@Column(name = "LEVEL_AKUN", nullable = false,length=1)
	private Integer levelAkun;
	
	@NotEmpty(message = "Tipe Akun tidak boleh kosong")
	@Column(name = "TIPE_AKUN", nullable = false,length=1)
	private String tipeAkun;
	
	@NotEmpty(message = "Saldo Awal tidak boleh kosong")
	@Column(name = "SALDO_AWAL", nullable = false)
	private BigDecimal saldoAwal;
	
	@NotEmpty(message = "Saldo Ytd tidak boleh kosong")
	@Column(name = "SALDO_YTD", nullable = false)
	private BigDecimal saldoYtd;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AKUN_FK")
	private Akun akun;
	
	@Column(name = "AKUN_FK", insertable = false, updatable = false)
	private String akunId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AKUN_GRUP_FK")
	@NotEmpty(message = "Akun Grup tidak boleh kosong")
	private AkunGrup akunGrup;
	
	@Column(name = "AKUN_GRUP_FK", nullable=false, insertable = false, updatable = false)
	private String akunGrupId;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "akun", cascade = CascadeType.ALL)
	private List<Akun> listAkun = new ArrayList<Akun>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "akun", cascade = CascadeType.ALL)
	private List<KasBank> listKasBank = new ArrayList<KasBank>();
	
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

	public String getPositionDk() {
		return positionDk;
	}

	public void setPositionDk(String positionDk) {
		this.positionDk = positionDk;
	}

	public Integer getLevelAkun() {
		return levelAkun;
	}

	public void setLevelAkun(Integer levelAkun) {
		this.levelAkun = levelAkun;
	}

	public String getTipeAkun() {
		return tipeAkun;
	}

	public void setTipeAkun(String tipeAkun) {
		this.tipeAkun = tipeAkun;
	}

	public BigDecimal getSaldoAwal() {
		return saldoAwal;
	}

	public void setSaldoAwal(BigDecimal saldoAwal) {
		this.saldoAwal = saldoAwal;
	}

	public BigDecimal getSaldoYtd() {
		return saldoYtd;
	}

	public void setSaldoYtd(BigDecimal saldoYtd) {
		this.saldoYtd = saldoYtd;
	}

	public Akun getAkun() {
		return akun;
	}

	public void setAkun(Akun akun) {
		this.akun = akun;
	}

	public String getAkunId() {
		return akunId;
	}

	public void setAkunId(String akunId) {
		this.akunId = akunId;
	}

	public AkunGrup getAkunGrup() {
		return akunGrup;
	}

	public void setAkunGrup(AkunGrup akunGrup) {
		this.akunGrup = akunGrup;
	}

	public String getAkunGrupId() {
		return akunGrupId;
	}

	public void setAkunGrupId(String akunGrupId) {
		this.akunGrupId = akunGrupId;
	}

	public List<Akun> getListAkun() {
		return listAkun;
	}

	public void setListAkun(List<Akun> listAkun) {
		this.listAkun = listAkun;
	}

	public List<KasBank> getListKasBank() {
		return listKasBank;
	}

	public void setListKasBank(List<KasBank> listKasBank) {
		this.listKasBank = listKasBank;
	}
	
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "akun", cascade = CascadeType.ALL)
	private Set<AwalHutang> awalHutangSet = new HashSet<AwalHutang>();*/
	
	
	
}
