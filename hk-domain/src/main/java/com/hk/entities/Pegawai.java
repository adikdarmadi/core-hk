package com.hk.entities;

import java.math.BigDecimal;
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
@Table(name = "M_PEGAWAI")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pegawai extends BaseModel {

	@Id
	@NotEmpty(message = "ID tidak boleh kosong")
	@Column(name = "PEGAWAI_ID", nullable = false,length=50)
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	@Column(name = "NAMA", nullable = false,length=100)
	private String nama;

	@NotEmpty(message = "Jenis Kelamin (LP) tidak boleh kosong")
	@Column(name = "LP", nullable = false,length=1)
	private String lp;

	@NotNull(message = "Alamat tidak boleh null")
	@Column(name = "ALAMAT", nullable = false)
	private String alamat;

	@NotNull(message = "Kota tidak boleh null")
	@Column(name = "KOTA", nullable = false,length=50)
	private String kota;

	@NotEmpty(message = "Tanggal Lahir tidak boleh kosong")
	@Column(name = "TANGGAL_LAHIR", nullable = false)
	private Date tanggalLahir;

	@NotNull(message = "No.HP tidak boleh null")
	@Column(name = "NO_HP", nullable = false,length=25)
	private String noHp;

	@NotNull(message = "No.HP tidak boleh null")
	@Column(name = "NO_TELEPON", nullable = false,length=25)
	private String noTelepon;

	@NotNull(message = "Email tidak boleh null")
	@Column(name = "EMAIL", nullable = false,length=50)
	private String email;

	@NotEmpty(message = "Agama tidak boleh kosong")
	@Column(name = "AGAMA", nullable = false,length=15)
	private String agama;

	@NotEmpty(message = "No.KTP tidak boleh kosong")
	@Column(name = "NO_KTP", nullable = false,length=30)
	private String noKtp;

	@NotNull(message = "No.SIM tidak boleh null")
	@Column(name = "NO_SIM", nullable = false,length=30)
	private String noSim;

	@NotEmpty(message = "Divisi tidak boleh kosong")
	@Column(name = "DIVISI", nullable = false,length=20)
	private String divisi;

	@NotEmpty(message = "Golongan tidak boleh kosong")
	@Column(name = "GOL", nullable = false,length=20)
	private String gol;

	@NotEmpty(message = "Status tidak boleh kosong")
	@Column(name = "STATUS", nullable = false,length=15)
	private String status;

	@Column(name = "MULAI_BEKERJA")
	private Date mulaiBekerja;

	@Column(name = "AKHIR_KONTRAK")
	private Date akhirKontrak;

	@NotNull(message = "Jabatan tidak boleh null")
	@Column(name = "JABATAN", nullable = false,length=50)
	private String jabatan;

	@Column(name = "BANK",length=100)
	private String bank;

	@Column(name = "ATAS_NAMA",length=100)
	private String atasNama;

	@Column(name = "NO_REKENING",length=50)
	private String noRekening;
	
	@NotEmpty(message = "Plafon Rp tidak boleh kosong")
	@Column(name = "PLAFON_RP", nullable = false)
	private BigDecimal  plafonRp;

	@NotEmpty(message = "Gaji Pokok tidak boleh kosong")
	@Column(name = "GAJI_POKOK", nullable = false)
	private BigDecimal  gajiPokok;

	@NotEmpty(message = "Uang Jabatan tidak boleh kosong")
	@Column(name = "UANG_JABATAN", nullable = false)
	private BigDecimal  uangJabatan;

	@NotEmpty(message = "Uang Hadir tidak boleh kosong")
	@Column(name = "UANG_HADIR", nullable = false)
	private BigDecimal  uangHadir;

	@NotEmpty(message = "Bonus tidak boleh kosong")
	@Column(name = "BONUS", nullable = false)
	private BigDecimal  bonus;

	@NotEmpty(message = "Is Active tidak boleh kosong")
	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;

	@Column(name = "DATE_NON_ACTIVE")
	private Date dateNonActive;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATA_UANG_FK")
	@NotEmpty(message = "Mata Uang tidak boleh kosong")
	private MataUang mataUang;

	@Column(name = "MATA_UANG_FK", nullable=false, insertable = false, updatable = false)
	private String mataUangId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AKUN_FK")
	@NotEmpty(message = "Akun tidak boleh kosong")
	private Akun akun;

	@Column(name = "AKUN_FK", nullable=false, insertable = false, updatable = false)
	private String akunId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_HDR_FK")
	@NotEmpty(message = "Department tidak boleh kosong")
	private DepartmentHdr department;

	@Column(name = "DEPARTMENT_HDR_FK", nullable=false, insertable = false, updatable = false)
	private String departmentId;
	
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

	public String getLp() {
		return lp;
	}

	public void setLp(String lp) {
		this.lp = lp;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public String getNoTelepon() {
		return noTelepon;
	}

	public void setNoTelepon(String noTelepon) {
		this.noTelepon = noTelepon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getNoKtp() {
		return noKtp;
	}

	public void setNoKtp(String noKtp) {
		this.noKtp = noKtp;
	}

	public String getNoSim() {
		return noSim;
	}

	public void setNoSim(String noSim) {
		this.noSim = noSim;
	}

	public String getDivisi() {
		return divisi;
	}

	public void setDivisi(String divisi) {
		this.divisi = divisi;
	}

	public String getGol() {
		return gol;
	}

	public void setGol(String gol) {
		this.gol = gol;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getMulaiBekerja() {
		return mulaiBekerja;
	}

	public void setMulaiBekerja(Date mulaiBekerja) {
		this.mulaiBekerja = mulaiBekerja;
	}

	public Date getAkhirKontrak() {
		return akhirKontrak;
	}

	public void setAkhirKontrak(Date akhirKontrak) {
		this.akhirKontrak = akhirKontrak;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAtasNama() {
		return atasNama;
	}

	public void setAtasNama(String atasNama) {
		this.atasNama = atasNama;
	}

	public String getNoRekening() {
		return noRekening;
	}

	public void setNoRekening(String noRekening) {
		this.noRekening = noRekening;
	}

	public BigDecimal getPlafonRp() {
		return plafonRp;
	}

	public void setPlafonRp(BigDecimal plafonRp) {
		this.plafonRp = plafonRp;
	}

	public BigDecimal getGajiPokok() {
		return gajiPokok;
	}

	public void setGajiPokok(BigDecimal gajiPokok) {
		this.gajiPokok = gajiPokok;
	}

	public BigDecimal getUangJabatan() {
		return uangJabatan;
	}

	public void setUangJabatan(BigDecimal uangJabatan) {
		this.uangJabatan = uangJabatan;
	}

	public BigDecimal getUangHadir() {
		return uangHadir;
	}

	public void setUangHadir(BigDecimal uangHadir) {
		this.uangHadir = uangHadir;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
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

	public MataUang getMataUang() {
		return mataUang;
	}

	public void setMataUang(MataUang mataUang) {
		this.mataUang = mataUang;
	}

	public String getMataUangId() {
		return mataUangId;
	}

	public void setMataUangId(String mataUangId) {
		this.mataUangId = mataUangId;
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

	public DepartmentHdr getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentHdr department) {
		this.department = department;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	
}
