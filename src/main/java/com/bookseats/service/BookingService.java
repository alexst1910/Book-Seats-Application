package com.bookseats.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;


import com.bookseats.converter.BookingConverter;
import com.bookseats.dto.BookingDTO;
import com.bookseats.entity.BookingEntity;
import com.bookseats.entity.UserEntity;
import com.bookseats.entity.VenueEntity;
import com.bookseats.repository.BookingRepository;
import com.bookseats.repository.UserRepository;
import com.bookseats.repository.VenueRepository;

@Service
public class BookingService {

List<BookingDTO> bookings = new ArrayList<BookingDTO>();
	
   BookingRepository bookingRepository;
   UserRepository userRepository;
   VenueRepository venueRepository;
   
	public BookingService(BookingRepository bookingRepository, UserRepository userRepository, VenueRepository venueRepository) {
		this.bookingRepository=bookingRepository;
		this.userRepository=userRepository;
		this.venueRepository=venueRepository;
		
	}
	
	public List<BookingDTO> getBookings(){
		return Streamable.of(bookingRepository.findAll()).map(bookingEntity -> BookingConverter.toDto(bookingEntity)).toList();
	}
	
	public BookingDTO addBooking(BookingEntity booking, Long userId, Long venueId) {
		
		UserEntity user=userRepository.findByUserId(userId).orElseThrow(()-> new RuntimeException("user not found"));
		VenueEntity venue=venueRepository.findByVenueId(venueId).orElseThrow(()-> new RuntimeException("venue not found"));
		
		booking.setUser(user);
		booking.setVenue(venue);
		bookingRepository.save(booking);
		venue.setAvailableSeats(decreaseAvailableSeats(booking,venue));
		venueRepository.save(venue);
		return BookingConverter.toDto(booking);
	}
	
	public BookingDTO updateBooking(Long bookingId, Long userId, Long venueId, LocalDate date, LocalTime timeFrom, LocalTime timeTo, Integer seats ) {
		
		UserEntity user=userRepository.findByUserId(userId).orElseThrow(()-> new RuntimeException("user not found"));
		VenueEntity venue=venueRepository.findByVenueId(venueId).orElseThrow(()-> new RuntimeException("venue not found"));
		
		BookingEntity booking=bookingRepository.findByBookingId(bookingId).orElseThrow(()-> new RuntimeException("booking not found"));
		
		if(date!= null) booking.setDate(date);
		if(timeFrom !=null) booking.setTimeFrom(timeFrom);
		if(timeTo != null) booking.setTimeTo(timeTo);
		if(seats !=null) booking.setSeats(seats);
		
		booking.setUser(user);
		booking.setVenue(venue);
		
		
		bookingRepository.save(booking);
		
		return BookingConverter.toDto(booking);
			
	
	}
	
	// updates the venue's available seats after saving booking
	public Integer decreaseAvailableSeats(BookingEntity booking, VenueEntity venue) {
		Integer availableSeats=venue.getAvailableSeats();
		Integer bookingSeats=booking.getSeats();
		return availableSeats-=bookingSeats;
		
	}
	
	// updates the venue's available seats after deleting booking
	public Integer increaseAvailableSeats(BookingEntity booking, VenueEntity venue) {
		
		Integer availableSeats=venue.getAvailableSeats();
		Integer bookingSeats=booking.getSeats();
		return availableSeats+=bookingSeats;
		
	}
	
	public BookingDTO getBookingById(Long id){
		return bookingRepository.findByBookingId(id).map(bookingEntity -> BookingConverter.toDto(bookingEntity)).orElse(null);
	}
	

	
	public Boolean deleteBooking(Long bookingId, Long userId, Long venueId) {
		
		
		UserEntity user=userRepository.findByUserId(userId).orElseThrow(()-> new RuntimeException("user not found"));
		BookingEntity booking=bookingRepository.findByBookingId(bookingId).orElseThrow(()-> new RuntimeException("booking not found"));
		VenueEntity venue=venueRepository.findByVenueId(venueId).orElseThrow(()-> new RuntimeException("venue not found"));

		// removing the booking from both venue and user
		user.getBookings().remove(booking);
		venue.getBookings().remove(booking);

		bookingRepository.deleteById(bookingId);
		
		// increasing available seats for venue
		venue.setAvailableSeats(increaseAvailableSeats(booking,venue));

		userRepository.save(user);
		venueRepository.save(venue);
		
		return true;
	}
	
	
}
