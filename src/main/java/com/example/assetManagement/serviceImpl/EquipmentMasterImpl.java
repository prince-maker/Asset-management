package com.example.assetManagement.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assetManagement.domain.EquipmentMaster;
import com.example.assetManagement.model.EquipmentMasterModel;
import com.example.assetManagement.repository.IEquipmentMasterRepo;
import com.example.assetManagement.service.IEquipmentMaster;

@Service
public class EquipmentMasterImpl implements IEquipmentMaster{
	
	@Autowired
	IEquipmentMasterRepo iEquipmentMasterRepo;

	@Override
	public EquipmentMasterModel add(EquipmentMasterModel equipmentMasterModel) {
		EquipmentMaster equipmentMaster=new EquipmentMaster();
		BeanUtils.copyProperties(equipmentMasterModel, equipmentMaster);
		equipmentMaster.setCreatedDate(new Date());
		equipmentMaster=iEquipmentMasterRepo.save(equipmentMaster);
		BeanUtils.copyProperties(equipmentMaster, equipmentMasterModel);

		return equipmentMasterModel;
	}

	@Override
	public List<EquipmentMasterModel> getAll() {
		
		List<EquipmentMaster> equipmentMasters=iEquipmentMasterRepo.findAll();
		List<EquipmentMasterModel> equipmentMasterModels=new ArrayList<>();
		equipmentMasters.forEach(equipmentMaster->{
			EquipmentMasterModel equipmentMasterModel=new EquipmentMasterModel();
			BeanUtils.copyProperties(equipmentMaster, equipmentMasterModel);
			
			equipmentMasterModels.add(equipmentMasterModel);
			
			
		});
		return equipmentMasterModels;
	}

}
