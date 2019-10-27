


package com.example.assetManagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assetManagement.domain.AccessPolicyDomain;
import com.example.assetManagement.domain.Role;
import com.example.assetManagement.model.AccessPolicyModel;
import com.example.assetManagement.model.RoleModel;
import com.example.assetManagement.repository.RoleRepository;
import com.example.assetManagement.service.IRole;

@Service
public class RoleServiceImpl implements IRole{
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public RoleModel add(RoleModel roleModel) {
		Role role=new Role();
		BeanUtils.copyProperties(roleModel, role);
		role=roleRepository.save(role);
		BeanUtils.copyProperties(role, roleModel);
		return roleModel;
	}

	@Override
	public List<RoleModel> getAll() {
		List<RoleModel> models=new ArrayList<RoleModel>();
		List<Role> domains=roleRepository.findAll();
		domains.forEach(domain->{
			RoleModel model=new RoleModel();
			BeanUtils.copyProperties(domain, model);
			
			
			
			
		});
		return models;
		
	}

}
