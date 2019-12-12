package com.example.assetManagement.model;

import java.util.Date;

public class SparePartModel {
	
	private Long sparePartId;
	 
	   
	   
    private String sparePartname;
    
   
    private Date createdDate;
    
    
    private Date updatedDate;

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
    
    

}
