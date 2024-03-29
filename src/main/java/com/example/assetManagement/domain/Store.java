package com.example.assetManagement.domain;

	
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId;
	private String address;
	private String cityName;
	private String storeCode;
	private String storeStatus;
	private String regionName;
	private Integer phNo;
	private String ownerName;
	private String costCentre;
	private String storeTypeName;
	
	@OneToMany(mappedBy= "store")
    List<EquipmentInventory> equipmentInventory= new ArrayList<>();
	
	@OneToMany(mappedBy= "store")
    List<SparePartInventry> sparePartInventry= new ArrayList<>();
	
	
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreStatus() {
		return storeStatus;
	}
	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getPhNo() {
		return phNo;
	}
	public void setPhNo(Integer phNo) {
		this.phNo = phNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getCostCentre() {
		return costCentre;
	}
	public void setCostCentre(String costCentre) {
		this.costCentre = costCentre;
	}
	public String getStoreTypeName() {
		return storeTypeName;
	}
	public void setStoreTypeName(String storeTypeName) {
		this.storeTypeName = storeTypeName;
	}
	public List<EquipmentInventory> getEquipmentInventory() {
		return equipmentInventory;
	}
	public void setEquipmentInventory(List<EquipmentInventory> equipmentInventory) {
		this.equipmentInventory = equipmentInventory;
	}
	public List<SparePartInventry> getSparePartInventry() {
		return sparePartInventry;
	}
	public void setSparePartInventry(List<SparePartInventry> sparePartInventry) {
		this.sparePartInventry = sparePartInventry;
	}
	
	
	
}
