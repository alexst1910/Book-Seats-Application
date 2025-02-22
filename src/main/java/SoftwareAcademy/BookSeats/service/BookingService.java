package SoftwareAcademy.BookSeats.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;


import SoftwareAcademy.BookSeats.converter.BookingConverter;
import SoftwareAcademy.BookSeats.dto.BookingDTO;
import SoftwareAcademy.BookSeats.dto.VenueDTO;
import SoftwareAcademy.BookSeats.entity.BookingEntity;
import SoftwareAcademy.BookSeats.entity.UserEntity;
import SoftwareAcademy.BookSeats.entity.VenueEntity;
import SoftwareAcademy.BookSeats.repository.BookingRepository;
import SoftwareAcademy.BookSeats.repository.UserRepository;
import SoftwareAcademy.BookSeats.repository.VenueRepository;

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
	
	public void addBooking(BookingDTO booking, VenueDTO venue) {
		
		BookingEntity bookingEntity=BookingConverter.toEntity(booking);
		
		// logic to assign the user id to booking
		if (booking.getUser() != null && booking.getUser().getUserId() != null) {
				
		        UserEntity existingUser = userRepository.findById(booking.getUser().getUserId())
		                .orElseThrow(() -> new RuntimeException("User not found with ID: " + booking.getUser().getUserId()));
		        bookingEntity.setUser(existingUser); 
		    } else {
		        throw new RuntimeException("User must be provided when creating a booking.");
		    }
	
		// logic to assign the venue id to booking
		if (booking.getVenue() != null && booking.getVenue().getVenueId() != null) {
			
	        VenueEntity existingVenue = venueRepository.findById(booking.getVenue().getVenueId())
	                .orElseThrow(() -> new RuntimeException("Venue not found with ID: " + booking.getVenue().getVenueId()));
	        bookingEntity.setVenue(existingVenue); 
	    } else {
	        throw new RuntimeException("Venue must be provided when creating a booking.");
	    }
		
		
		 bookingRepository.save(bookingEntity);
	}
	
	public Boolean deleteBooking(Long id) {
		bookingRepository.deleteById(id);
		return true;
	}
}
