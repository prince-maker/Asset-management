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

import com.example.assetManagement.model.RoleModel;
import com.example.assetManagement.model.StoreModel;
import com.example.assetManagement.service.IRoleService;
import com.example.assetManagement.service.IstoreService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/store")
public class StoreController {

	@Autowired
	IstoreService istoreService;
	
	@PostMapping("/save")
    public ResponseEntity<?> addStore( @RequestBody StoreModel storeModel) {
		storeModel=istoreService.add(storeModel);
      
        return new ResponseEntity<>(storeModel,HttpStatus.OK);
    }
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllStore(){
		List<StoreModel> storeModel=istoreService.getAll();
		
		return new ResponseEntity<>(storeModel,HttpStatus.OK);
		
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getByStoreId(@PathVariable("id") Long id){
		StoreModel storeModel=istoreService.getByStoreId(id);
		
		return new ResponseEntity<>(storeModel,HttpStatus.OK);
		
	}
}
