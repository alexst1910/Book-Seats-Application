package SoftwareAcademy.BookSeats.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/updateBooking/{userId}/{venueId}")
	public ResponseEntity<Map<String, Object>> updateBooking(
			Long bookingId,
			@PathVariable Long userId,
			@PathVariable Long venueId, 
			@RequestParam (value="date") LocalDate date,
			@RequestParam (value="timeFrom") LocalTime timeFrom,
			@RequestParam (value="timeTo") LocalTime timeTo,
			@RequestParam (value="seats") Integer seats
			){
		
		bookingService.updateBooking(bookingId, date, timeFrom, timeTo, seats, userId, venueId);
		Map<String, Object> response=new HashMap<>();
		
		response.put("message", "user saved");
		return ResponseEntity.ok(response);
	}
	

	
	@DeleteMapping("/deleteBookingById/{id}")
	public ResponseEntity<Map<String, Object>> deleteBooking(@PathVariable Long id) {
		 bookingService.deleteBooking(id);
		 Map<String, Object> response=new HashMap<>();
		 response.put("message", "booking deleted!");
		 return ResponseEntity.ok(response);
		
	}
	
	

}
