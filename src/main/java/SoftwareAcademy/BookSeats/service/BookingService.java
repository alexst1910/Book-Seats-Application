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
		
		BookingDTO firstBooking =new BookingDTO();
		firstBooking.setBookingId(2L);
		firstBooking.setDate(LocalDate.of(2025, 1, 24));
		firstBooking.setTimeFrom(LocalTime.of(20, 00));
		firstBooking.setTimeTo(LocalTime.of(23, 00));
		firstBooking.setSeats(5);
		
		bookings.add(firstBooking);
	}
	
	public List<BookingDTO> getBookings(){
		return bookings;
	}
	
	public void addBooking(BookingDTO booking) {
		bookings.add(booking);
	}
	
	public Boolean deleteBooking(Long id) {
		return bookings.removeIf(booking -> booking.getBookingId()==id);
	}
}
