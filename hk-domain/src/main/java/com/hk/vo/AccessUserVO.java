package com.hk.vo;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *  class AccessUser
 * 
 * @author Generator
 */
public class AccessUserVO  {

	@NotEmpty(message = "User tidak boleh kosong")
	private String userId;
	
	//private List<String> modules;
	
	private List<AccessUserChildVO> listAccessUserChildVO;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*public List<String> getModules() {
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}*/

	public List<AccessUserChildVO> getListAccessUserChildVO() {
		return listAccessUserChildVO;
	}

	public void setListAccessUserChildVO(List<AccessUserChildVO> listAccessUserChildVO) {
		this.listAccessUserChildVO = listAccessUserChildVO;
	}

	
}

