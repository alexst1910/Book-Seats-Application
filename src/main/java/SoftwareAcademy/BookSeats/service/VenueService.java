package SoftwareAcademy.BookSeats.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import SoftwareAcademy.BookSeats.converter.BookingConverter;
import SoftwareAcademy.BookSeats.converter.VenueConverter;
import SoftwareAcademy.BookSeats.dto.BookingDTO;
import SoftwareAcademy.BookSeats.dto.VenueDTO;
import SoftwareAcademy.BookSeats.entity.BookingEntity;
import SoftwareAcademy.BookSeats.entity.UserEntity;
import SoftwareAcademy.BookSeats.entity.VenueEntity;
import SoftwareAcademy.BookSeats.repository.VenueRepository;

@Service
public class VenueService {

	VenueRepository venueRepository;
	
	
	public VenueService(VenueRepository venueRepository) {
		
		this.venueRepository=venueRepository;
		
	}
	
	public List<VenueDTO> getVenues(){
		return Streamable.of(venueRepository.findAll()).map(venueEntity -> VenueConverter.toDtoWithBookings(venueEntity)).toList();
	}
	
	
	
	public VenueDTO getVenuesById(Long id){
		
		// returns a single venue
		return venueRepository.findByVenueId(id).map(venueEntity->VenueConverter.toDtoWithBookings(venueEntity)).orElse(null);
		
	}
	
	public VenueDTO updateVenue( Long venueId, String name, String address, Integer totalSeats, Integer availableSeats, String cover ) {
			
			
			VenueEntity venue=venueRepository.findByVenueId(venueId).orElseThrow(()-> new RuntimeException("venue not found"));
			
			if(name!= null) venue.setName(name);
			if(address !=null) venue.setAddress(address);
			if(totalSeats != null) venue.setTotalSeats(totalSeats);
			if(availableSeats !=null) venue.setAvailableSeats(availableSeats);
			if(cover!= null )
			
			venueRepository.save(venue);
			
			return VenueConverter.toDto(venue);
				
		
		}
	
	public VenueDTO addVenue(VenueEntity venue) {
		
		venueRepository.save(venue);
		return VenueConverter.toDto(venue);
		
		}
	
	
	public Boolean deleteVenue(Long id) {
		
		venueRepository.deleteById(id);
		return true;	}
	
}
