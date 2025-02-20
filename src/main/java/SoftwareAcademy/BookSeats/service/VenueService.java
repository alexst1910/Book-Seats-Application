package SoftwareAcademy.BookSeats.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import SoftwareAcademy.BookSeats.dto.VenueDTO;

@Service
public class VenueService {

	List<VenueDTO> venues = new ArrayList<VenueDTO>();
	
	public VenueService() {
		VenueDTO firstVenue =new VenueDTO();
		
		
	}
	
	public List<VenueDTO> getVenues(){
		return venues;
	}
	
	
	public void addVenue(VenueDTO venue) {
		venues.add(venue);
		
		
		}
	
	
	public Boolean deleteVenue(Long id) {
		return true;	}
}
