package com.example.assetManagement.model;

import java.util.Date;

public class EquipmentInventoryModel {
	
	 private Long equipmentInventryId;
	 
	   
	   
	    private String equipmentSerialName;
	   
	    
	    private String description;
	    
	    
	    private Date createdDate;
	    
	   
	    private Date updatedDate;
	    
	 
	    private Long equipmentId;
	    
	    private String equipmentName;

	  
	    private  Long storeId;
	    
	    private String storeName;

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

		public Long getEquipmentId() {
			return equipmentId;
		}

		public void setEquipmentId(Long equipmentId) {
			this.equipmentId = equipmentId;
		}

		public String getEquipmentName() {
			return equipmentName;
		}

		public void setEquipmentName(String equipmentName) {
			this.equipmentName = equipmentName;
		}

		public Long getStoreId() {
			return storeId;
		}

		public void setStoreId(Long storeId) {
			this.storeId = storeId;
		}

		public String getStoreName() {
			return storeName;
		}

		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
	    
	    

	    
	    

}
