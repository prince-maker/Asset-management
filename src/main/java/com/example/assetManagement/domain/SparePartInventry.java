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

@Entity
@Table(name = "Sparepartinventry")
public class SparePartInventry {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sparePartInventryId;
 
   
   
    private String sparePartSerialNO;
    
    private String description;
    
    @CreationTimestamp
    private Date createdDate;
    
    @UpdateTimestamp
    private Date updatedDate;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "sparePartId")
    private SparePart sparePart;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "storeId")
    private  Store store;

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

	public SparePart getSparePart() {
		return sparePart;
	}

	public void setSparePart(SparePart sparePart) {
		this.sparePart = sparePart;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
    
    

}
