package com.hk.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class InisialProteksi {
	@Column(name = "TGL_PROTEKSI_REQUEST_BELI")
	@NotNull(message = "Tgl Proteksi Request Pembelian tidak boleh kosong")
	private Date tglProteksiRequestBeli;
	
	@Column(name = "TGL_PROTEKSI_ORDER_PEMBELIAN")
	@NotNull(message = "Tgl Proteksi Order Pembelian tidak boleh kosong")
	private Date tglProteksiOrderPembelian;
	
	@Column(name = "TGL_PROTEKSI_FAKTUR_PEMBELIAN")
	@NotNull(message = "Tgl Proteksi Order Pembelian tidak boleh kosong")
	private Date tglProteksiFakturPembelian;
	
	@Column(name = "TGL_PROTEKSI_BATAL_ORDER_BELI")
	@NotNull(message = "Tgl Proteksi Pembatalan Order Pembelian tidak boleh kosong")
	private Date tglProteksiBatalOrderBeli;

	@Column(name = "TGL_PROTEKSI_RETUR_BELI")
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
