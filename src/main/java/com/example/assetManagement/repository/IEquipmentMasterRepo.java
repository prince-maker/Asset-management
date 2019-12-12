package com.example.assetManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetManagement.domain.EquipmentMaster;

public interface IEquipmentMasterRepo extends JpaRepository<EquipmentMaster, Long>{

}
