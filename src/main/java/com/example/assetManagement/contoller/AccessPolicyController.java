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

import com.example.assetManagement.domain.AccessPolicyDomain;
import com.example.assetManagement.model.AccessPolicyModel;
import com.example.assetManagement.service.IAccessPolicyService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/accessPolicy")
public class AccessPolicyController 
{
	
	@Autowired
	IAccessPolicyService iAccessPolicyService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addAccessPolicy(@RequestBody AccessPolicyModel model) throws Exception
	{
		model= iAccessPolicyService.addAccessPolicy(model);
		
		return  new ResponseEntity<>(model,HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	
	public ResponseEntity<?> getallAccessPolicy() throws Exception
	{
		List<AccessPolicyModel>models= iAccessPolicyService.getAll();
		
		return new ResponseEntity<>(models,HttpStatus.OK);
	}
	
	
	
	

}
