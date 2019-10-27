package com.example.assetManagement.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	
	@Entity
	@Table(name = "users")
	public class UserDomain {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userId;
	 
	   
	    private String name;
	 
	    
	    private String username;
	 
	    
	    private String email;
	 
	  
	    private String password;
	 
	    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	    @JoinColumn(name = "id")
	    private Role roles;
	 
	    public UserDomain() {}
	 
	    public UserDomain(String name, String username, String email, String password) {
	        this.name = name;
	        this.username = username;
	        this.email = email;
	        this.password = password;
	    }
	 
	   
	 
	    public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getUsername() {
	        return username;
	    }
	 
	    public void setUsername(String username) {
	        this.username = username;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
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

		public Role getRoles() {
			return roles;
		}

		public void setRoles(Role roles) {
			this.roles = roles;
		}
	 
	   
	
	

}
