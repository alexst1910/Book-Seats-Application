package SoftwareAcademy.BookSeats.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.BookingDTO;



@RestController
public class BookingController {
	
	List<BookingDTO> bookings = new ArrayList<BookingDTO>();
	
	public BookingController() {
		
		BookingDTO firstBooking =new BookingDTO();
		firstBooking.setBookingId(2L);
		firstBooking.setDate(LocalDate.of(2025, 1, 24));
		firstBooking.setTimeFrom(LocalTime.of(20, 00));
		firstBooking.setTimeTo(LocalTime.of(23, 00));
		firstBooking.setSeats(5);
		
		bookings.add(firstBooking);
	}
	
	
	@GetMapping("/getBooking")
	public List<BookingDTO> getBookings(){
		return bookings;
	}

}
