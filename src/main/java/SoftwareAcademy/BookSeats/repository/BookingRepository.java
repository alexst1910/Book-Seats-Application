package SoftwareAcademy.BookSeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SoftwareAcademy.BookSeats.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long>{

}
