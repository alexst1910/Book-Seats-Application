package SoftwareAcademy.BookSeats.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SoftwareAcademy.BookSeats.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long>{

	public List <BookingEntity> findByBookingId(Long id);
}
