package com.example.assetManagement.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assetManagement.domain.EquipmentInventory;
import com.example.assetManagement.model.EquipmentInventoryModel;
import com.example.assetManagement.model.EquipmentMasterModel;
import com.example.assetManagement.service.IEquipmentInventory;
import com.example.assetManagement.service.IEquipmentMaster;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/equipmentMasterInventory")
public class EquipmentInventoryController {
	
	
	@Autowired
	IEquipmentInventory iEquipmentInventory;
	
	
	@PostMapping("/save")
    public ResponseEntity<?> saveEquipmentInventory( @RequestBody EquipmentInventoryModel equipmentInventoryModel) {
		equipmentInventoryModel=iEquipmentInventory.add(equipmentInventoryModel);
      
        return new ResponseEntity<>(equipmentInventoryModel,HttpStatus.OK);
    }
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllEquipmentsInventory(){
		List<EquipmentInventoryModel> equipmentInventoryModel=iEquipmentInventory.getAll();
		
		return new ResponseEntity<>(equipmentInventoryModel,HttpStatus.OK);
		
	}

}
