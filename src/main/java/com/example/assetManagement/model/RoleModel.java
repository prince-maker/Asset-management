package com.example.assetManagement.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.NaturalId;

import com.example.assetManagement.utlis.RoleName;

public class RoleModel {
	
	private Long roleId;
	 
    @Enumerated(EnumType.STRING)
    private RoleName name;
    
  
 
    public RoleModel() {}
 
    public RoleModel(RoleName name) {
        this.name = name;
    }
 
   
    public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public RoleName getName() {
        return name;
    }
 
    public void setName(RoleName name) {
        this.name = name;
    }


}
