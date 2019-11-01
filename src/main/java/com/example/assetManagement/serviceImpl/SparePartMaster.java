package com.example.assetManagement.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assetManagement.domain.EquipmentMaster;
import com.example.assetManagement.domain.SparePart;
import com.example.assetManagement.domain.Store;
import com.example.assetManagement.model.EquipmentMasterModel;
import com.example.assetManagement.model.SparePartModel;
import com.example.assetManagement.model.StoreModel;
import com.example.assetManagement.repository.ISparePartsRepo;
import com.example.assetManagement.service.ISparePartMaster;

@Service
public class SparePartMaster implements ISparePartMaster{

	@Autowired
	ISparePartsRepo iSparePartsRepo;
	
	
	
	@Override
	public SparePartModel add(SparePartModel sparePartModel) {
		SparePart sparePart=new SparePart();
		BeanUtils.copyProperties(sparePartModel, sparePart);
		sparePart.setCreatedDate(new Date());
		
		sparePart=iSparePartsRepo.save(sparePart);
		BeanUtils.copyProperties(sparePart, sparePartModel);

		return sparePartModel;
		
	}

	@Override
	public List<SparePartModel> getAll() {
		List<SparePart> spareParts=iSparePartsRepo.findAll();
		List<SparePartModel> SparePartModels=new ArrayList<>();
		spareParts.forEach(sparePart->{
			SparePartModel sparePartModel=new SparePartModel();
			BeanUtils.copyProperties(sparePart, sparePartModel);
			
			SparePartModels.add(sparePartModel);
			
			
		});
		return SparePartModels;
		
	}

	@Override
	public SparePartModel getBySpareId(Long id) {
		SparePart sparePart;
		try {
			sparePart = iSparePartsRepo.findById(id).orElseThrow(()->new RuntimeException("Spare id not found"));
			
			SparePartModel sparePartModel=new SparePartModel();
			BeanUtils.copyProperties(sparePart, sparePartModel);
			
		
			return sparePartModel;
			} catch (RuntimeException e) {
	
				throw e;
	}
}
		
	}


