package com.bookseats.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookseats.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long>{

	public Optional <BookingEntity> findByBookingId(Long id);
}
