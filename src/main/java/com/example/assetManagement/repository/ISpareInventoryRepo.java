package com.example.assetManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetManagement.domain.SparePartInventry;

public interface ISpareInventoryRepo extends JpaRepository<SparePartInventry, Long>{

}
