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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.BookingDTO;
import SoftwareAcademy.BookSeats.dto.VenueDTO;
import SoftwareAcademy.BookSeats.service.BookingService;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/allBookings")
	public List<BookingDTO> getBookings(){
		return bookingService.getBookings();
	}
	
	@PostMapping("/addBooking")
	public String addBooking(@RequestBody BookingDTO booking, VenueDTO venue) {
		
	

		bookingService.addBooking(booking, venue);
		return "booking has been saved";
	}
	
	
	@PostMapping("/submitBooking")
	public String submitBooking(@RequestParam LocalDate date,
            @RequestParam Integer seats,
            @RequestParam LocalTime timeFrom,
            @RequestParam LocalTime timeTo,
            @RequestParam VenueDTO venue) {
			BookingDTO booking = new BookingDTO();
			booking.setDate(date);
			booking.setSeats(seats);
			booking.setTimeFrom(timeFrom);
			booking.setTimeTo(timeTo);
			booking.setVenue(venue);

			bookingService.addBooking(booking, venue);
			return "booking has been saved";
}
	
	@DeleteMapping("/deleteBookingById/{id}")
	public Boolean deleteBooking(@PathVariable Long id) {
		return bookingService.deleteBooking(id);
	}
	
	

}
