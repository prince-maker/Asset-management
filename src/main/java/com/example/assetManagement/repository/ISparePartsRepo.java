package com.example.assetManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assetManagement.domain.SparePart;

public interface ISparePartsRepo extends JpaRepository<SparePart, Long>{

}
