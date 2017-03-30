package com.hk.vo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * class UserMRU
 * 
 * @author Generator
 */

public class UserMRUVO {

	@NotEmpty(message = "User tidak boleh kosong")
	private String userId;
	
	@NotEmpty(message = "Module State tidak boleh kosong")
	private String moduleState;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getModuleState() {
		return moduleState;
	}

	public void setModuleState(String moduleState) {
		this.moduleState = moduleState;
	}

	
}