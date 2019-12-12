package com.example.assetManagement.model;

public class AccessPolicyModel 
{
	
	 private Long accessPolicyId;
	 
	 private String accessPolicyname;
	    
	 private String description;
	 
	 private Long roleId;
	 
	 private String roleName;

	public Long getAccessPolicyId() {
		return accessPolicyId;
	}

	public void setAccessPolicyId(Long accessPolicyId) {
		this.accessPolicyId = accessPolicyId;
	}

	public String getAccessPolicyname() {
		return accessPolicyname;
	}

	public void setAccessPolicyname(String accessPolicyname) {
		this.accessPolicyname = accessPolicyname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	    
	 
	 

}
