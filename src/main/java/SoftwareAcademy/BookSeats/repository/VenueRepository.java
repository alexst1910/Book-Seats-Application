package SoftwareAcademy.BookSeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SoftwareAcademy.BookSeats.entity.VenueEntity;

public interface VenueRepository extends JpaRepository<VenueEntity, Long>{

}
