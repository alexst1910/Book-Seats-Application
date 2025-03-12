package com.bookseats.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookseats.entity.VenueEntity;

public interface VenueRepository extends JpaRepository<VenueEntity, Long>{

	public Optional <VenueEntity> findByVenueId(Long id);
	
}
