package com.hk.vo;

import javax.validation.constraints.NotNull;

/**
 * class Produk
 * 
 * @author Generator
 */
public class ProdukVO {
	
	private Integer id;

	@NotNull(message="Detail Jenis Produk Harus Diisi")
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