package com.example.assetManagement.service;

import java.util.List;

import com.example.assetManagement.model.EquipmentMasterModel;

public interface IEquipmentMaster{

	EquipmentMasterModel add(EquipmentMasterModel equipmentMasterModel);

	List<EquipmentMasterModel> getAll();

}