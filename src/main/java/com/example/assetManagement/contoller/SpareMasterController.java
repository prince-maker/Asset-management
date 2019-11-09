package com.example.assetManagement.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assetManagement.model.EquipmentMasterModel;
import com.example.assetManagement.model.SparePartModel;
import com.example.assetManagement.model.StoreModel;
import com.example.assetManagement.service.IEquipmentMaster;
import com.example.assetManagement.service.ISparePartMaster;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/spareMaster")
public class SpareMasterController {
	
	@Autowired
	ISparePartMaster iSparePartMaster;
	
	
	@PostMapping("/save")
    public ResponseEntity<?> saveSpare( @RequestBody  SparePartModel sparePartModel) {
		sparePartModel=iSparePartMaster.add(sparePartModel);
      
        return new ResponseEntity<>(sparePartModel,HttpStatus.OK);
    }
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllSpares(){
		List<SparePartModel> sparePartModel=iSparePartMaster.getAll();
		
		return new ResponseEntity<>(sparePartModel,HttpStatus.OK);
		
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getBySpareId(@PathVariable("id") Long id){
		SparePartModel sparePartModel=iSparePartMaster.getBySpareId(id);
		
		return new ResponseEntity<>(sparePartModel,HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
    public ResponseEntity<?> upadteSpare( @RequestBody  SparePartModel sparePartModel) {
		sparePartModel=iSparePartMaster.update(sparePartModel);
      
        return new ResponseEntity<>(sparePartModel,HttpStatus.OK);
    }


}
