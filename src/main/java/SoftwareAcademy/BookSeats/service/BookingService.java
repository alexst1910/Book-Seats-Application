package SoftwareAcademy.BookSeats.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import SoftwareAcademy.BookSeats.converter.BookingConverter;
import SoftwareAcademy.BookSeats.converter.UserConverter;
import SoftwareAcademy.BookSeats.dto.BookingDTO;
import SoftwareAcademy.BookSeats.entity.BookingEntity;
import SoftwareAcademy.BookSeats.repository.BookingRepository;

@Service
public class BookingService {

List<BookingDTO> bookings = new ArrayList<BookingDTO>();
	
   BookingRepository bookingRepository;
   
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository=bookingRepository;
		
	}
	
	public List<BookingDTO> getBookings(){
		return Streamable.of(bookingRepository.findAll()).map(bookingEntity -> BookingConverter.toDto(bookingEntity)).toList();
	}
	
	public void addBooking(BookingDTO booking) {
		BookingEntity bookingEntity=BookingConverter.toEntity(booking);
		bookingRepository.save(bookingEntity);
	}
	
	public Boolean deleteBooking(Long id) {
		bookingRepository.deleteById(id);
		return true;
	}
}
