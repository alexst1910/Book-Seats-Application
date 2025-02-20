package SoftwareAcademy.BookSeats.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import SoftwareAcademy.BookSeats.dto.BookingDTO;

@Service
public class BookingService {

List<BookingDTO> bookings = new ArrayList<BookingDTO>();
	
	public BookingService() {
		
		
	}
	
	public List<BookingDTO> getBookings(){
		return bookings;
	}
	
	public void addBooking(BookingDTO booking) {
		bookings.add(booking);
	}
	
	public Boolean deleteBooking(Long id) {
		return true;
	}
}
