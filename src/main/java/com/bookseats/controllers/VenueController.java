package com.bookseats.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bookseats.dto.VenueDTO;
import com.bookseats.entity.VenueEntity;
import com.bookseats.service.VenueService;
import org.springframework.web.multipart.MultipartFile;


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


	@PostMapping(value = "/addVenue", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Map<String, Object>> addVenue(@RequestPart("venue") VenueDTO venueDto, @RequestPart("imageFile") MultipartFile imageFile) throws IOException {

		String fileName = imageFile.getOriginalFilename();
		Path imagePath = Paths.get("uploads/images/", fileName);
		Files.createDirectories(imagePath.getParent());
		Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

		VenueEntity venue = new VenueEntity();
		venue.setName(venueDto.getName());
		venue.setAddress(venueDto.getAddress());
		venue.setTotalSeats(venueDto.getTotalSeats());
		venue.setAvailableSeats(venueDto.getAvailableSeats());
		venue.setCover("/uploads/images/" + fileName);


		VenueDTO savedVenue = venueService.addVenue(venue);

		venueService.addVenue(venue);
		Map<String, Object> response=new HashMap<>();
		response.put("venue", savedVenue);
		response.put("message", "venue saved");
		return ResponseEntity.ok(response);

		
		}
	
	@PutMapping("/updateVenue/{venueId}")
	@PreAuthorize("hasAuthority('ADMIN')")
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
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Map<String, Object>> deleteVenue(@PathVariable Long id) {
		
		 venueService.deleteVenue(id);
		Map<String, Object> response=new HashMap<>();
		response.put("message", "venue deleted");
		return ResponseEntity.ok(response);
		
		}
}
