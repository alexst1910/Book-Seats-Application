package SoftwareAcademy.BookSeats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SoftwareAcademy.BookSeats.entity.VenueEntity;

public interface VenueRepository extends JpaRepository<VenueEntity, Long>{

	public List<VenueEntity> findByVenueId(Long id);
}
