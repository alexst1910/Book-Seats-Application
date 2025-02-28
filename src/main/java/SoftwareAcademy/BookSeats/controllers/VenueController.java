package SoftwareAcademy.BookSeats.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.VenueDTO;
import SoftwareAcademy.BookSeats.entity.VenueEntity;
import SoftwareAcademy.BookSeats.service.VenueService;



@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/venue")
public class VenueController {

	@Autowired
	VenueService venueService;
	
	@GetMapping("/getVenue")
	public List<VenueDTO> getVenues(){
		return venueService.getVenues();
	}
	
	@GetMapping("/getVenueById/{id}")
	public VenueDTO getVenuesById(@PathVariable Long id){
		return venueService.getVenuesById(id);
	}
	
	@PostMapping("/addVenue")
	public ResponseEntity<Map<String, Object>> addVenue(@RequestBody VenueEntity venue) {
		venueService.addVenue(venue);
		System.out.println("venue: "+ venue);
		Map<String, Object> response=new HashMap<>();
		response.put("venue", venue);
		response.put("message", "venue saved");
		return ResponseEntity.ok(response);
		
		
		}
	
	@DeleteMapping("/deleteVenueById/{id}")
	public Boolean deleteVenue(@PathVariable Long id) {
		return venueService.deleteVenue(id);
		}
}
