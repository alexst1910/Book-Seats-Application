package com.bookseats.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookseats.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	public List<UserEntity> findAllByFirstNameContaining(String firstName);
	public Optional<UserEntity> findByUsername(String username);
	public Boolean existsByEmail(String email);
	public Optional <UserEntity> findByEmail(String email);
	public Optional <UserEntity> findByUserId(Long id);
}
