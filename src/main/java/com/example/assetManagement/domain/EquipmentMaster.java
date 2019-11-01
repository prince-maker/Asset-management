package com.example.assetManagement.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "equipment")
public class EquipmentMaster {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;
 
   
   
    private String equipmentname;
    
    @CreationTimestamp
    private Date createdDate;
    
    @UpdateTimestamp
    private Date updatedDate;
    
    @OneToMany(mappedBy= "equipmentMaster")
    List<EquipmentInventory> equipmentInventory= new ArrayList<>();

    @OneToMany(mappedBy= "equipmentMaster")
    List<SparePart> sparePart= new ArrayList<>();
   
	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentname() {
		return equipmentname;
	}

	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<EquipmentInventory> getEquipmentInventory() {
		return equipmentInventory;
	}

	public void setEquipmentInventory(List<EquipmentInventory> equipmentInventory) {
		this.equipmentInventory = equipmentInventory;
	}

	public List<SparePart> getSparePart() {
		return sparePart;
	}

	public void setSparePart(List<SparePart> sparePart) {
		this.sparePart = sparePart;
	}
    
   

}
