package com.example.assetManagement.service;

import java.util.List;

import com.example.assetManagement.model.RoleModel;

public interface IRoleService {

	RoleModel add(RoleModel roleModel);

	List<RoleModel> getAll();

}
