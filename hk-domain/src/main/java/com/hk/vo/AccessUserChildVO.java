package com.hk.vo;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *  class ListAccessUser
 * 
 * @author Generator
 */

public class AccessUserChildVO  {

	private String id;
	
	private Boolean selected;
	
	private Boolean __ivhTreeviewIndeterminate;
	
	private List<AccessUserChildVO> children;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	public Boolean get__ivhTreeviewIndeterminate() {
		return __ivhTreeviewIndeterminate;
	}
	public void set__ivhTreeviewIndeterminate(Boolean __ivhTreeviewIndeterminate) {
		this.__ivhTreeviewIndeterminate = __ivhTreeviewIndeterminate;
	}
	public List<AccessUserChildVO> getChildren() {
		return children;
	}
	public void setChildren(List<AccessUserChildVO> children) {
		this.children = children;
	}

	
}

