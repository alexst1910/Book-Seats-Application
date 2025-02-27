package SoftwareAcademy.BookSeats.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import SoftwareAcademy.BookSeats.converter.VenueConverter;
import SoftwareAcademy.BookSeats.dto.VenueDTO;
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
	
	
	// reevaluate tomorrow
	public List<VenueDTO> getVenuesById(Long id){
		return venueRepository.findByVenueId(id).map(venueEntity->VenueConverter.toDtoWithBookings(venueEntity)).stream().toList();
		
	}
	
	
	public VenueDTO addVenue(VenueEntity venue) {
		
		venueRepository.save(venue);
		return VenueConverter.toDto(venue);
		
		}
	
	
	public Boolean deleteVenue(Long id) {
		
		venueRepository.deleteById(id);
		return true;	}
	
}
