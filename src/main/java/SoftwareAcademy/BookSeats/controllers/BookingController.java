package SoftwareAcademy.BookSeats.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.BookingDTO;
import SoftwareAcademy.BookSeats.service.BookingService;



@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/allBookings")
	public List<BookingDTO> getBookings(){
		return bookingService.getBookings();
	}
	
	@PostMapping("/addBooking")
	public String addBooking(@RequestBody BookingDTO booking) {
		bookingService.addBooking(booking);
		return "booking has been saved";
	}
	
	@DeleteMapping("/deleteBookingById/{id}")
	public Boolean deleteBooking(@PathVariable Long id) {
		return bookingService.deleteBooking(id);
	}
	
	

}
