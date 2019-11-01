package com.example.assetManagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.assetManagement.domain.SparePart;
import com.example.assetManagement.domain.Store;

public class SpareInventoryModel {
	
	private Long sparePartInventryId;
	 
	   
	   
    private String sparePartSerialNO;
    
    private String description;
    
  
    private Date createdDate;
    
   
    private Date updatedDate;
    
  
    private Long sparePartId;
    
    private String spareParName;
    
    
    
    private  Long storeId;
    private  String storeName;
	public Long getSparePartInventryId() {
		return sparePartInventryId;
	}
	public void setSparePartInventryId(Long sparePartInventryId) {
		this.sparePartInventryId = sparePartInventryId;
	}
	public String getSparePartSerialNO() {
		return sparePartSerialNO;
	}
	public void setSparePartSerialNO(String sparePartSerialNO) {
		this.sparePartSerialNO = sparePartSerialNO;
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
	public Long getSparePartId() {
		return sparePartId;
	}
	public void setSparePartId(Long sparePartId) {
		this.sparePartId = sparePartId;
	}
	public String getSpareParName() {
		return spareParName;
	}
	public void setSpareParName(String spareParName) {
		this.spareParName = spareParName;
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
