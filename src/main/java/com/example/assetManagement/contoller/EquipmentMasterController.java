package com.example.assetManagement.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assetManagement.model.EquipmentMasterModel;
import com.example.assetManagement.model.RoleModel;
import com.example.assetManagement.model.SparePartModel;
import com.example.assetManagement.service.IEquipmentMaster;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/equipmentMaster")
public class EquipmentMasterController {
	
	@Autowired
	IEquipmentMaster iEquipmentMaster;
	
	
	@PostMapping("/save")
    public ResponseEntity<?> saveEquipment( @RequestBody EquipmentMasterModel equipmentMasterModel) {
		equipmentMasterModel=iEquipmentMaster.add(equipmentMasterModel);
      
        return new ResponseEntity<>(equipmentMasterModel,HttpStatus.OK);
    }
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllEquipments(){
		List<EquipmentMasterModel> equipmentMasterModel=iEquipmentMaster.getAll();
		
		return new ResponseEntity<>(equipmentMasterModel,HttpStatus.OK);
		
	}
	
	

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getByEquipmentId(@PathVariable("id") Long id){
		EquipmentMasterModel equipmentMasterModel=iEquipmentMaster.getByEquipmentId(id);
		
		return new ResponseEntity<>(equipmentMasterModel,HttpStatus.OK);
		
	}

}
