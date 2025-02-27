package SoftwareAcademy.BookSeats.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SoftwareAcademy.BookSeats.entity.VenueEntity;

public interface VenueRepository extends JpaRepository<VenueEntity, Long>{

	public Optional <VenueEntity> findByVenueId(Long id);
	
}
