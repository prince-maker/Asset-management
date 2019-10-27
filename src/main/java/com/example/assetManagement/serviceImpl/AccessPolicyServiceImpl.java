package com.example.assetManagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.assetManagement.domain.AccessPolicyDomain;
import com.example.assetManagement.domain.Role;
import com.example.assetManagement.model.AccessPolicyModel;
import com.example.assetManagement.repository.AccessPolicyRepository;
import com.example.assetManagement.repository.RoleRepository;
import com.example.assetManagement.service.IAccessPolicyService;

@Service
public class AccessPolicyServiceImpl implements IAccessPolicyService{

	@Autowired
	AccessPolicyRepository accessPolicyRepository;
	@Autowired
    RoleRepository roleRepository;
	
	
	@Override
	public AccessPolicyModel addAccessPolicy(AccessPolicyModel model) throws Exception  {
		AccessPolicyDomain accessPolicyDomain=new AccessPolicyDomain();
		BeanUtils.copyProperties(model, accessPolicyDomain);
		Role role=roleRepository.findById(model.getRoleId()).orElseThrow(()->new RoleNotFoundException("role not found"));
		accessPolicyDomain.setRoles(role);
		accessPolicyDomain=accessPolicyRepository.save(accessPolicyDomain);
		BeanUtils.copyProperties(accessPolicyDomain, model);
		return model;
	}


	@Override
	public List<AccessPolicyModel> getAll() {
		List<AccessPolicyModel> models=new ArrayList<AccessPolicyModel>();
		List<AccessPolicyDomain> domains=accessPolicyRepository.findAll();
		domains.forEach(domain->{
			AccessPolicyModel model=new AccessPolicyModel();
			BeanUtils.copyProperties(domain, model);
			model.setRoleId(domain.getRoles().getRoleId());
			model.setRoleName(domain.getRoles().getName().toString());
			models.add(model);
			
			
			
		});
		return models;
	}

	

	
	


	
	
	

}
