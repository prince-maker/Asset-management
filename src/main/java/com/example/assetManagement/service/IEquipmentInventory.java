package com.example.assetManagement.service;

import java.util.List;

import com.example.assetManagement.model.EquipmentInventoryModel;

public interface IEquipmentInventory {

	EquipmentInventoryModel add(EquipmentInventoryModel equipmentInventoryModel);

	List<EquipmentInventoryModel> getAll();

}
