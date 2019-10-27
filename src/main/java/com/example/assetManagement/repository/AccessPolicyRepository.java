package com.example.assetManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.assetManagement.domain.AccessPolicyDomain;


@Repository
public interface AccessPolicyRepository extends JpaRepository<AccessPolicyDomain, Long>
{






	

}
