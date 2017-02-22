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
	
	@NotEmpty(message = "Module tidak boleh kosong")
	private String moduleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	
}