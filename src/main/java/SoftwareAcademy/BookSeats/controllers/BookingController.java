package SoftwareAcademy.BookSeats.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.BookingDTO;
import SoftwareAcademy.BookSeats.dto.VenueDTO;
import SoftwareAcademy.BookSeats.entity.BookingEntity;
import SoftwareAcademy.BookSeats.service.BookingService;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/allBookings")
	public List<BookingDTO> getBookings(){
		return bookingService.getBookings();
	}
	
	@PostMapping("/addBooking/{userId}/{venueId}")
	public String addBooking(@RequestBody BookingEntity booking, @PathVariable Long userId, @PathVariable Long venueId) {
		

		bookingService.addBooking(booking, userId, venueId);
		return "booking has been saved";
	}
	

	
	@DeleteMapping("/deleteBookingById/{id}")
	public Boolean deleteBooking(@PathVariable Long id) {
		return bookingService.deleteBooking(id);
	}
	
	

}
