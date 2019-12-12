package com.example.assetManagement.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.example.assetManagement.utlis.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Role {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long roleId;
	 
	    @Enumerated(EnumType.STRING)
	    @NaturalId
	    @Column(length = 60)
	    private RoleName name;
	    

	    @OneToMany(mappedBy= "roles")
	    List<AccessPolicyDomain> accessPolicyDomain= new ArrayList<>();
	    
	    
	 
	    public Role() {}
	 
	    public Role(RoleName name) {
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

		public List<AccessPolicyDomain> getAccessPolicyDomain() {
			return accessPolicyDomain;
		}

		public void setAccessPolicyDomain(List<AccessPolicyDomain> accessPolicyDomain) {
			this.accessPolicyDomain = accessPolicyDomain;
		}
	    
	    

}
