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
@Table(name = "sparepart")
public class SparePart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sparePartId;
	 
	   
	   
    private String sparePartname;
    
    @CreationTimestamp
    private Date createdDate;
    
    @UpdateTimestamp
    private Date updatedDate;
    
    @OneToMany(mappedBy= "sparePart")
    List<SparePartInventry> sparePartInventry= new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "equipmentId",nullable = true)
    private EquipmentMaster equipmentMaster;

	public Long getSparePartId() {
		return sparePartId;
	}

	public void setSparePartId(Long sparePartId) {
		this.sparePartId = sparePartId;
	}

	public String getSparePartname() {
		return sparePartname;
	}

	public void setSparePartname(String sparePartname) {
		this.sparePartname = sparePartname;
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

	public List<SparePartInventry> getSparePartInventry() {
		return sparePartInventry;
	}

	public void setSparePartInventry(List<SparePartInventry> sparePartInventry) {
		this.sparePartInventry = sparePartInventry;
	}

	public EquipmentMaster getEquipmentMaster() {
		return equipmentMaster;
	}

	public void setEquipmentMaster(EquipmentMaster equipmentMaster) {
		this.equipmentMaster = equipmentMaster;
	}
    
    

   
}
