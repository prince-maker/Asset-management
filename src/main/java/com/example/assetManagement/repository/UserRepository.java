package com.example.assetManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assetManagement.domain.UserDomain;


@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long>{
	
	Optional<UserDomain> findByUsername(String username);
	
	

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
