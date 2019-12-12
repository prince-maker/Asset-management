package com.example.assetManagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.NaturalId;

import com.example.assetManagement.utlis.RoleName;

public class RoleModel {
	
	private Long roleId;
	 
    @Enumerated(EnumType.STRING)
    private RoleName name;
    
   private List<AccessPolicyModel> accessPolicyModel;
 
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

	public List<AccessPolicyModel> getAccessPolicyModel() {
		return accessPolicyModel;
	}

	public void setAccessPolicyModel(List<AccessPolicyModel> accessPolicyModel) {
		this.accessPolicyModel = accessPolicyModel;
	}

    

}
