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

import com.example.assetManagement.model.AccessPolicyModel;
import com.example.assetManagement.model.RoleModel;
import com.example.assetManagement.service.IRole;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	IRole roleService;
	
	@PostMapping("/save")
    public ResponseEntity<?> authenticateUser( @RequestBody RoleModel roleModel) {
		roleModel=roleService.add(roleModel);
      
        return new ResponseEntity<>(roleModel,HttpStatus.OK);
    }
  
	
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllRole(){
		List<RoleModel> roleModel=roleService.getAll();
		
		return new ResponseEntity<>(roleModel,HttpStatus.OK);
		
	}
	
 
}
