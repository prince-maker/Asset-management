package com.example.assetManagement.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.assetManagement.domain.AccessPolicyDomain;
import com.example.assetManagement.domain.EquipmentInventory;
import com.example.assetManagement.domain.EquipmentMaster;
import com.example.assetManagement.domain.Role;
import com.example.assetManagement.domain.Store;
import com.example.assetManagement.model.AccessPolicyModel;
import com.example.assetManagement.model.EquipmentInventoryModel;
import com.example.assetManagement.repository.IEquipmentInventoryRepo;
import com.example.assetManagement.repository.IEquipmentMasterRepo;
import com.example.assetManagement.repository.StoreRepo;
import com.example.assetManagement.service.IEquipmentInventory;

@Service
public class EquipmentInventoryImpl implements IEquipmentInventory{
	
	@Autowired
	private IEquipmentMasterRepo iEquipmentMasterRepo;
	
	@Autowired
	private IEquipmentInventoryRepo iEquipmentInventoryRepo;
	
	@Autowired
	private StoreRepo storeRepo;
	
	

	@Override
	public EquipmentInventoryModel add(EquipmentInventoryModel equipmentInventoryModel) {
		EquipmentInventory equipmentInventory=new EquipmentInventory();
		BeanUtils.copyProperties(equipmentInventoryModel, equipmentInventory);
		Store store=storeRepo.findById(equipmentInventoryModel.getStoreId()).orElseThrow(()->new RuntimeException("store  not found"));
		EquipmentMaster equipmentMaster=iEquipmentMasterRepo.findById(equipmentInventoryModel.getStoreId()).orElseThrow(()->new RuntimeException("equipmentmaster not found"));

		equipmentInventory.setStore(store);
		equipmentInventory.setEquipmentMaster(equipmentMaster);
		equipmentInventory.setCreatedDate(new Date());
		equipmentInventory=iEquipmentInventoryRepo.save(equipmentInventory);
		BeanUtils.copyProperties(equipmentInventory, equipmentInventoryModel);
		equipmentInventoryModel.setStoreId(equipmentInventory.getStore().getStoreId());
		equipmentInventoryModel.setStoreName(equipmentInventory.getStore().getStoreTypeName());
		equipmentInventoryModel.setEquipmentId(equipmentInventory.getEquipmentMaster().getEquipmentId());
		equipmentInventoryModel.setEquipmentName(equipmentInventory.getEquipmentMaster().getEquipmentname());
		return equipmentInventoryModel;
	}

	@Override
	public List<EquipmentInventoryModel> getAll() {
		List<EquipmentInventoryModel> equipmentInventoryModels=new ArrayList<EquipmentInventoryModel>();
		List<EquipmentInventory> equipmentInventorys=iEquipmentInventoryRepo.findAll();
		equipmentInventorys.forEach(equipmentInventory->{
			EquipmentInventoryModel equipmentInventoryModel=new EquipmentInventoryModel();
			BeanUtils.copyProperties(equipmentInventory, equipmentInventoryModel);
			equipmentInventoryModel.setStoreId(equipmentInventory.getStore().getStoreId());
			equipmentInventoryModel.setStoreName(equipmentInventory.getStore().getStoreTypeName());
			equipmentInventoryModel.setEquipmentId(equipmentInventory.getEquipmentMaster().getEquipmentId());
			equipmentInventoryModel.setEquipmentName(equipmentInventory.getEquipmentMaster().getEquipmentname());
			equipmentInventoryModels.add(equipmentInventoryModel);
			
			
			
		});
		return equipmentInventoryModels;
	}

}
