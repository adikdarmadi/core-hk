package com.hk.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * class Pegawai
 * 
 * @author Generator
 */
public class PegawaiVO {
	

	@NotNull(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;

	@NotEmpty(message = "Jenis Kelamin (LP) tidak boleh kosong")
	private String lp;

	@NotNull(message = "Alamat tidak boleh null")
	private String alamat;

	@NotNull(message = "Kota tidak boleh null")
	private String kota;

	@NotNull(message = "Tanggal Lahir tidak boleh kosong")
	private Date tanggalLahir;

	@NotNull(message = "No.HP tidak boleh null")
	private String noHp;

	@NotNull(message = "No.HP tidak boleh null")
	private String noTelepon;

	@NotNull(message = "Email tidak boleh null")
	private String email;

	@NotEmpty(message = "Agama tidak boleh kosong")
	private String agama;

	@NotEmpty(message = "No.KTP tidak boleh kosong")
	private String noKtp;

	@NotNull(message = "No.SIM tidak boleh null")
	private String noSim;

	@NotEmpty(message = "Divisi tidak boleh kosong")
	private String divisi;

	@NotEmpty(message = "Golongan tidak boleh kosong")
	private String gol;

	@NotEmpty(message = "Status tidak boleh kosong")
	private String status;

	private Date mulaiBekerja;

	private Date akhirKontrak;

	@NotNull(message = "Jabatan tidak boleh null")
	private String jabatan;

	private String bank;

	private String atasNama;

	private String noRekening;
	
	@NotNull(message = "Plafon Rp tidak boleh kosong")
	private BigDecimal  plafonRp;

	@NotNull(message = "Gaji Pokok tidak boleh kosong")
	private BigDecimal  gajiPokok;

	@NotNull(message = "Uang Jabatan tidak boleh kosong")
	private BigDecimal  uangJabatan;

	@NotNull(message = "Uang Hadir tidak boleh kosong")
	private BigDecimal  uangHadir;

	@NotNull(message = "Bonus tidak boleh kosong")
	private BigDecimal  bonus;
	
	@NotEmpty(message = "Mata Uang tidak boleh kosong")
	private String mataUangId;
	
	@NotEmpty(message = "Akun tidak boleh kosong")
	private String akunId;

	//@NotEmpty(message = "Department tidak boleh kosong")
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

	public String getMataUangId() {
		return mataUangId;
	}

	public void setMataUangId(String mataUangId) {
		this.mataUangId = mataUangId;
	}

	public String getAkunId() {
		return akunId;
	}

	public void setAkunId(String akunId) {
		this.akunId = akunId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
}