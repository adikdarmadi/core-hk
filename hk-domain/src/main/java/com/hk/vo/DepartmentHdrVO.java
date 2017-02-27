package com.hk.vo;


import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * class Role
 * 
 * @author Generator
 */
public class DepartmentHdrVO {
	

	@NotEmpty(message = "ID Tidak Boleh Kosong")
	private String id;

	@NotEmpty(message = "Nama tidak boleh kosong")
	private String nama;
	
	@NotEmpty(message="Detail Department Harus Terisi")
	//@Valid
	private List<DepartmentDtlVO> listDepartmentDtlVO;

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

	public List<DepartmentDtlVO> getListDepartmentDtlVO() {
		return listDepartmentDtlVO;
	}

	public void setListDepartmentDtlVO(List<DepartmentDtlVO> listDepartmentDtlVO) {
		this.listDepartmentDtlVO = listDepartmentDtlVO;
	}
	
}