package com.example.assetManagement.service;

import java.util.List;

import com.example.assetManagement.model.EquipmentMasterModel;
import com.example.assetManagement.model.SparePartModel;

public interface IEquipmentMaster{

	EquipmentMasterModel add(EquipmentMasterModel equipmentMasterModel);

	List<EquipmentMasterModel> getAll();

	EquipmentMasterModel getByEquipmentId(Long id);

	EquipmentMasterModel update(EquipmentMasterModel equipmentMasterModel);

}
