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

import com.example.assetManagement.domain.SparePartInventry;
import com.example.assetManagement.model.EquipmentInventoryModel;
import com.example.assetManagement.model.SpareInventoryModel;
import com.example.assetManagement.service.IEquipmentInventory;
import com.example.assetManagement.service.ISparePartInventory;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/spareInventory")
public class SpareInventoryController {
	
	@Autowired
	private ISparePartInventory iSparePartInventory;
	
	
	@PostMapping("/save")
    public ResponseEntity<?> saveSparePartInventory( @RequestBody SpareInventoryModel spareInventoryModel) {
		spareInventoryModel=iSparePartInventory.add(spareInventoryModel);
      
        return new ResponseEntity<>(spareInventoryModel,HttpStatus.OK);
    }
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllSparePartInventory(){
		List<SpareInventoryModel> spareInventoryModels=iSparePartInventory.getAll();
		
		return new ResponseEntity<>(spareInventoryModels,HttpStatus.OK);
		
	}


}
