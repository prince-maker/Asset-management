package com.example.assetManagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assetManagement.domain.Store;
import com.example.assetManagement.domain.UserDomain;
import com.example.assetManagement.model.StoreModel;
import com.example.assetManagement.model.UserModel;
import com.example.assetManagement.repository.StoreRepo;
import com.example.assetManagement.service.IstoreService;

@Service
public class StoreServiceImpl implements IstoreService{
	
	@Autowired
	StoreRepo storeRepo;

	@Override
	public StoreModel add(StoreModel storeModel) {
		Store store=new Store();
		BeanUtils.copyProperties(storeModel, store);
		
		store=storeRepo.save(store);
		BeanUtils.copyProperties(store, storeModel);

		return storeModel;
	}

	@Override
	public List<StoreModel> getAll() {
		List<Store> stores=storeRepo.findAll();
		List<StoreModel> storeModels=new ArrayList<>();
		stores.forEach(store->{
			StoreModel storeModel=new StoreModel();
			BeanUtils.copyProperties(store, storeModel);
			
			storeModels.add(storeModel);
			
			
		});
		return storeModels;
	}

	@Override
	public StoreModel getByStoreId(Long id)   {
		Store store;
		try {
			store = storeRepo.findById(id).orElseThrow(()->new RuntimeException("Store id not found"));
		
			StoreModel storeModel=new StoreModel();
			BeanUtils.copyProperties(store, storeModel);
		
			return storeModel;
			} catch (RuntimeException e) {
	
				throw e;
	}
}

}
