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
	
	public BookingDTO addBooking(BookingEntity booking, Long userId, Long venueId) {
		
		UserEntity user=userRepository.findByUserId(userId).orElseThrow(()-> new RuntimeException("user not found"));
		VenueEntity venue=venueRepository.findByVenueId(venueId).orElseThrow(()-> new RuntimeException("venue not found"));
		
		booking.setUser(user);
		booking.setVenue(venue);
		bookingRepository.save(booking);
		return BookingConverter.toDto(booking);
	}
	
	public List <BookingDTO> findById(BookingDTO booking, Long id){
		return Streamable.of(bookingRepository.findByBookingId(id)).map(bookingEntity -> BookingConverter.toDto(bookingEntity)).toList();
	}
	

	
	public Boolean deleteBooking(Long id) {
		bookingRepository.deleteById(id);
		return true;
	}
	
	
}
