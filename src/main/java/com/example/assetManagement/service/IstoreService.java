package com.example.assetManagement.service;

import java.util.List;

import com.example.assetManagement.model.StoreModel;

public interface IstoreService {

	StoreModel add(StoreModel storeModel);

	List<StoreModel> getAll();

	StoreModel getByStoreId(Long id);

}
