package com.bookseats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookseats.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
}
