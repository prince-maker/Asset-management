package com.example.assetManagement.service;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.http.ResponseEntity;


import com.example.assetManagement.domain.AccessPolicyDomain;
import com.example.assetManagement.model.AccessPolicyModel;


public interface IAccessPolicyService {

	AccessPolicyModel addAccessPolicy(AccessPolicyModel model) throws Exception ;

	List<AccessPolicyModel> getAll();






}
