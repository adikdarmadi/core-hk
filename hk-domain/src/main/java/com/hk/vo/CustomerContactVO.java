package com.hk.vo;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * class SupplierContactVO
 * 
 * @author Generator
 */

public class CustomerContactVO {
	
	@NotEmpty(message = "PIC tidak boleh kosong")
	private String pic;
	
	private String divisi;
	
	private String department;
	
	@NotEmpty(message = "Telepon tidak boleh kosong")
	private String telepon;
	
	private String hp;
	
	private String fax;
	
	private String email;

	private String customerId;
	
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDivisi() {
		return divisi;
	}

	public void setDivisi(String divisi) {
		this.divisi = divisi;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
	
}