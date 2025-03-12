package com.bookseats.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookseats.dto.VenueDTO;
import com.bookseats.entity.VenueEntity;
import com.bookseats.service.VenueService;



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
		Map<String, Object> response=new HashMap<>();
		response.put("venue", venue);
		response.put("message", "venue saved");
		return ResponseEntity.ok(response);
		
		
		}
	
	@PutMapping("/updateVenue/{venueId}")
	public ResponseEntity<Map<String, Object>> updateVenue(
			@PathVariable Long venueId,
			@RequestParam (value="name", required=false) String name,
			@RequestParam (value="address", required=false) String address,
			@RequestParam (value="totalSeats", required=false) Integer totalSeats,
			@RequestParam (value="availableSeats", required=false) Integer availableSeats,
			@RequestParam (value="cover", required=false) String cover
			){
		
		venueService.updateVenue(venueId, name, address, totalSeats, availableSeats, cover);
		Map<String, Object> response=new HashMap<>();
		
		response.put("message", "venue updated");
		return ResponseEntity.ok(response);
		
	}
	
	@DeleteMapping("/deleteVenueById/{id}")
	public ResponseEntity<Map<String, Object>> deleteVenue(@PathVariable Long id) {
		
		 venueService.deleteVenue(id);
		Map<String, Object> response=new HashMap<>();
		response.put("message", "venue deleted");
		return ResponseEntity.ok(response);
		
		}
}
