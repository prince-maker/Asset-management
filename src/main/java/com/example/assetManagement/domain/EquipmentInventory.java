package com.example.assetManagement.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.TituloEleitoral;


@Entity
@Table(name = "equipmentinventory")
public class EquipmentInventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentInventryId;
 
   
   
    private String equipmentSerialName;
   
    
    private String description;
    
    @CreationTimestamp
    private Date createdDate;
    
    @UpdateTimestamp
    private Date updatedDate;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "equipmentId")
    private EquipmentMaster equipmentMaster;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "storeId")
    private  Store store;
    
	public Long getEquipmentInventryId() {
		return equipmentInventryId;
	}

	public void setEquipmentInventryId(Long equipmentInventryId) {
		this.equipmentInventryId = equipmentInventryId;
	}

	public String getEquipmentSerialName() {
		return equipmentSerialName;
	}

	public void setEquipmentSerialName(String equipmentSerialName) {
		this.equipmentSerialName = equipmentSerialName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public EquipmentMaster getEquipmentMaster() {
		return equipmentMaster;
	}

	public void setEquipmentMaster(EquipmentMaster equipmentMaster) {
		this.equipmentMaster = equipmentMaster;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
   
    

}
