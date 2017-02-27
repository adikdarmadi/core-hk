package com.hk.vo;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *  class Agama
 * 
 * @author Generator
 */
//@Entity
//@Table(name = "Agama_M")
public class AccessUserVO  {

	@NotEmpty(message = "User tidak boleh kosong")
	private String userId;
	
	private List<String> modules;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getModules() {
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}

}

