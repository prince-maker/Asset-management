package com.example.assetManagement.model;

import com.example.assetManagement.domain.Role;

public class UserModel {
	
	private Long userId;
	
    private String name;
 
 
    private String username;
 
   
    private String email;
    
    private RoleModel roles;
    
    private Long reportingId;
    private String reportingTo;
    
   private String role;
    private String password;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public RoleModel getRoles() {
		return roles;
	}

	public void setRoles(RoleModel roles) {
		this.roles = roles;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getReportingId() {
		return reportingId;
	}

	public void setReportingId(Long reportingId) {
		this.reportingId = reportingId;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	


    
	
   
}
