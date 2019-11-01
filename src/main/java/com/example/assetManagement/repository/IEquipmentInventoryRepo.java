package com.example.assetManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetManagement.domain.EquipmentInventory;

public interface IEquipmentInventoryRepo extends JpaRepository<EquipmentInventory, Long>{

}
