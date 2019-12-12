package com.example.assetManagement.model;

import java.util.Date;



public class EquipmentMasterModel {
	
	private Long equipmentId;
	 
	   
	   
    private String equipmentname;
    
    
    private Date createdDate;
    
   
    private Date updatedDate;


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

    
}
