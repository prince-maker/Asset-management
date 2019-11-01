package com.example.assetManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetManagement.domain.Store;

public interface StoreRepo extends JpaRepository<Store, Long>{

}
