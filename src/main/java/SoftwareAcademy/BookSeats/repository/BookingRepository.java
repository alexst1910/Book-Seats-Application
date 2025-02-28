package SoftwareAcademy.BookSeats.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SoftwareAcademy.BookSeats.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long>{

	public Optional <BookingEntity> findByBookingId(Long id);
}
