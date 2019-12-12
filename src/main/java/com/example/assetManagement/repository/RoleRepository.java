package com.example.assetManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assetManagement.domain.Role;
import com.example.assetManagement.utlis.RoleName;

@Repository

public interface RoleRepository extends JpaRepository<Role, Long>{

	
    Optional<Role> findByName(RoleName roleName);

}
