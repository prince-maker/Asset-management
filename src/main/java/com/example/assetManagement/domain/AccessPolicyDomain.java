package com.example.assetManagement.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AccessPolicyDomain {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long accessPolicyId;
	 
	   
	   
	    private String accessPolicyname;
	    
	    private String description;
	    
	    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	    @JoinColumn(name = "id")
	    private Role roles;

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

		public Role getRoles() {
			return roles;
		}

		public void setRoles(Role roles) {
			this.roles = roles;
		}
        
		
		
	    
	    
	    

}
