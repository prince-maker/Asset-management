package com.example.assetManagement.service;

import java.util.List;

import com.example.assetManagement.model.SpareInventoryModel;

public interface ISparePartInventory {

	SpareInventoryModel add(SpareInventoryModel spareInventoryModel);

	List<SpareInventoryModel> getAll();

}
