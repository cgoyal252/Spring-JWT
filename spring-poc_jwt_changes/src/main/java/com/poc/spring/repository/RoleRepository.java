package com.poc.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.spring.model.Role;
import com.poc.spring.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long>  {

	// Optional<Role> findByName(RoleName roleUser); 
	 
	 Role findByName(RoleName roleUser);
	
}
