package com.hk.vo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * class Role
 * 
 * @author Generator
 */
public class DepartmentDtlVO {
	
	private String departmentHdrId;

	@NotEmpty(message = "Shift tidak boleh kosong")
	private String shift;

	@NotEmpty(message = "Jam Masuk tidak boleh kosong")
	private String jamMasuk;

	@NotEmpty(message = "Jam Keluar tidak boleh kosong")
	private String jamKeluar;

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

}