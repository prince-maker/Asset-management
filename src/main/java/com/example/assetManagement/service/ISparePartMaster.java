package com.example.assetManagement.service;

import java.util.List;

import com.example.assetManagement.model.SparePartModel;

public interface ISparePartMaster {

	SparePartModel add(SparePartModel sparePartModel);

	List<SparePartModel> getAll();

	SparePartModel getBySpareId(Long id);

	SparePartModel update(SparePartModel sparePartModel);

}
