package com.hk.vo;


import java.util.Date;

import javax.validation.constraints.NotNull;


/**
 * class InisialProteksi
 * 
 * @author Generator
 */
public class InisialProteksiVO {
	

	@NotNull(message = "Tgl Proteksi Request Pembelian tidak boleh kosong")
	private Date tglProteksiRequestBeli;
	
	@NotNull(message = "Tgl Proteksi Order Pembelian tidak boleh kosong")
	private Date tglProteksiOrderPembelian;
	
	@NotNull(message = "Tgl Proteksi Order Pembelian tidak boleh kosong")
	private Date tglProteksiFakturPembelian;
	
	@NotNull(message = "Tgl Proteksi Pembatalan Order Pembelian tidak boleh kosong")
	private Date tglProteksiBatalOrderBeli;

	@NotNull(message = "Tgl Proteksi Retur Pembelian tidak boleh kosong")
	private Date tglProteksiReturBeli;

	public Date getTglProteksiRequestBeli() {
		return tglProteksiRequestBeli;
	}

	public void setTglProteksiRequestBeli(Date tglProteksiRequestBeli) {
		this.tglProteksiRequestBeli = tglProteksiRequestBeli;
	}

	public Date getTglProteksiOrderPembelian() {
		return tglProteksiOrderPembelian;
	}

	public void setTglProteksiOrderPembelian(Date tglProteksiOrderPembelian) {
		this.tglProteksiOrderPembelian = tglProteksiOrderPembelian;
	}

	public Date getTglProteksiFakturPembelian() {
		return tglProteksiFakturPembelian;
	}

	public void setTglProteksiFakturPembelian(Date tglProteksiFakturPembelian) {
		this.tglProteksiFakturPembelian = tglProteksiFakturPembelian;
	}

	public Date getTglProteksiBatalOrderBeli() {
		return tglProteksiBatalOrderBeli;
	}

	public void setTglProteksiBatalOrderBeli(Date tglProteksiBatalOrderBeli) {
		this.tglProteksiBatalOrderBeli = tglProteksiBatalOrderBeli;
	}

	public Date getTglProteksiReturBeli() {
		return tglProteksiReturBeli;
	}

	public void setTglProteksiReturBeli(Date tglProteksiReturBeli) {
		this.tglProteksiReturBeli = tglProteksiReturBeli;
	}
	
	
}