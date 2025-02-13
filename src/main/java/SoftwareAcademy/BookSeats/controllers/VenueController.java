package SoftwareAcademy.BookSeats.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.VenueDTO;




@RestController
public class VenueController {

List<VenueDTO> venues = new ArrayList<VenueDTO>();
	
	public VenueController() {
		
		VenueDTO firstVenue =new VenueDTO();
		firstVenue.setVenueId(2L);
		firstVenue.setName("Music Pub");
		firstVenue.setAddress("Sibiu");
		firstVenue.setAvailableSeats(100);
		
		
		venues.add(firstVenue);
	}
	
	
	@GetMapping("/getVenue")
	public List<VenueDTO> getVenues(){
		return venues;
	}
	
	@PostMapping("/addVenue")
	public String addVenue(@RequestBody VenueDTO venue) {
		venues.add(venue);
		return "venue has been saved";
		
		}
	
	@DeleteMapping("/deleteVenueById/{id}")
	public Boolean deleteVenue(@PathVariable Long id) {
		return venues.removeIf(venue -> venue.getVenueId() == id);	}
}
