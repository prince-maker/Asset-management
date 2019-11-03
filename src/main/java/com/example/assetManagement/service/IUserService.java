package com.example.assetManagement.service;

import java.util.List;

import com.example.assetManagement.domain.UserDomain;
import com.example.assetManagement.model.UserModel;

public interface IUserService {

	List<UserModel> getAll();

	UserDomain findByUserName(String name);

	UserModel getByUserId(Long id);

}
