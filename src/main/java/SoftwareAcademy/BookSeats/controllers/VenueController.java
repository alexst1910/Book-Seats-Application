package SoftwareAcademy.BookSeats.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.VenueDTO;
import SoftwareAcademy.BookSeats.service.VenueService;



@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class VenueController {

	@Autowired
	VenueService venueService;
	
	@GetMapping("/getVenue")
	public List<VenueDTO> getVenues(){
		return venueService.getVenues();
	}
	
	@GetMapping("/getVenueById/{id}")
	public List<VenueDTO> getVenuesById(@PathVariable Long id){
		return venueService.getVenuesById(id);
	}
	
	@PostMapping("/addVenue")
	public String addVenue(@RequestBody VenueDTO venue) {
		venueService.addVenue(venue);
		return "venue has been saved";
		
		}
	
	@DeleteMapping("/deleteVenueById/{id}")
	public Boolean deleteVenue(@PathVariable Long id) {
		return venueService.deleteVenue(id);
		}
}
