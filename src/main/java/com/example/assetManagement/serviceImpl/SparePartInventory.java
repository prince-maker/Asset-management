package com.example.assetManagement.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assetManagement.domain.EquipmentInventory;
import com.example.assetManagement.domain.EquipmentMaster;
import com.example.assetManagement.domain.SparePart;
import com.example.assetManagement.domain.SparePartInventry;
import com.example.assetManagement.domain.Store;
import com.example.assetManagement.model.EquipmentInventoryModel;
import com.example.assetManagement.model.SpareInventoryModel;
import com.example.assetManagement.repository.IEquipmentInventoryRepo;
import com.example.assetManagement.repository.IEquipmentMasterRepo;
import com.example.assetManagement.repository.ISpareInventoryRepo;
import com.example.assetManagement.repository.ISparePartsRepo;
import com.example.assetManagement.repository.StoreRepo;
import com.example.assetManagement.service.ISparePartInventory;
import com.example.assetManagement.service.ISparePartMaster;

@Service
public class SparePartInventory implements ISparePartInventory{
	
	@Autowired
	private ISpareInventoryRepo iSpareInventoryRepo;
	
	@Autowired
	private ISparePartsRepo iSparePartsRepo;
	
	@Autowired
	private StoreRepo storeRepo;

	@Override
	public SpareInventoryModel add(SpareInventoryModel spareInventoryModel) {
		
		SparePartInventry sparePartInventry=new SparePartInventry();
		BeanUtils.copyProperties(spareInventoryModel, sparePartInventry);
		Store store=storeRepo.findById(spareInventoryModel.getStoreId()).orElseThrow(()->new RuntimeException("store  not found"));
		SparePart sparePart=iSparePartsRepo.findById(spareInventoryModel.getSparePartId()).orElseThrow(()->new RuntimeException("equipmentmaster not found"));

		sparePartInventry.setStore(store);
		sparePartInventry.setSparePart(sparePart);
		sparePartInventry.setCreatedDate(new Date());
		sparePartInventry=iSpareInventoryRepo.save(sparePartInventry);
		BeanUtils.copyProperties(sparePartInventry, spareInventoryModel);
		spareInventoryModel.setStoreId(sparePartInventry.getStore().getStoreId());
		spareInventoryModel.setStoreName(sparePartInventry.getStore().getStoreTypeName());
		spareInventoryModel.setSparePartId(sparePartInventry.getSparePart().getSparePartId());
		spareInventoryModel.setSpareParName(sparePartInventry.getSparePart().getSparePartname());
		return spareInventoryModel;
	}

	@Override
	public List<SpareInventoryModel> getAll() {
		List<SpareInventoryModel> spareInventoryModels=new ArrayList<SpareInventoryModel>();
		List<SparePartInventry> sparePartInventrys=iSpareInventoryRepo.findAll();
		sparePartInventrys.forEach(sparePartInventry->{
			SpareInventoryModel spareInventoryModel=new SpareInventoryModel();
			BeanUtils.copyProperties(sparePartInventry, spareInventoryModel);
			spareInventoryModel.setStoreId(sparePartInventry.getStore().getStoreId());
			spareInventoryModel.setStoreName(sparePartInventry.getStore().getStoreTypeName());
			spareInventoryModel.setSparePartId(sparePartInventry.getSparePart().getSparePartId());
			spareInventoryModel.setSpareParName(sparePartInventry.getSparePart().getSparePartname());
			spareInventoryModels.add(spareInventoryModel);
			
			
			
		});
		return spareInventoryModels;
	}

}
