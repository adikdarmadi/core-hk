package com.hk.vo;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.hk.entities.DetailJenisProduk;

/**
 * class Produk
 * 
 * @author Generator
 */
public class ProdukVO {
	
	private Integer id;

	@NotEmpty(message="Detail Jenis Produk Harus Diisi")
	private DetailJenisProdukVO detailJenisProduk;

	private String namaProduk;


	public String getNamaProduk() {
		return namaProduk;
	}

	public void setNamaProduk(String namaProduk) {
		this.namaProduk = namaProduk;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DetailJenisProdukVO getDetailJenisProduk() {
		return detailJenisProduk;
	}

	public void setDetailJenisProduk(DetailJenisProdukVO detailJenisProduk) {
		this.detailJenisProduk = detailJenisProduk;
	}

	
	
}