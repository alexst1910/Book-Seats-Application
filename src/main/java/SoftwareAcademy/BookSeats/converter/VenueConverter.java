package SoftwareAcademy.BookSeats.converter;

import SoftwareAcademy.BookSeats.dto.UserDTO;
import SoftwareAcademy.BookSeats.dto.VenueDTO;
import SoftwareAcademy.BookSeats.entity.UserEntity;
import SoftwareAcademy.BookSeats.entity.VenueEntity;

public class VenueConverter {
	
	public static VenueDTO toDtoWithBookings(VenueEntity venueEntity) {
		VenueDTO dto=toDto(venueEntity);
		dto.setBookings(venueEntity.getBookings().stream().map(bookingEntity -> BookingConverter.toDto(bookingEntity)).toList());
		
		return dto;
	}

	public static VenueDTO toDto(VenueEntity venueEntity) {
		VenueDTO dto= new VenueDTO();
		dto.setVenueId(venueEntity.getVenueId());
		dto.setName(venueEntity.getName());
		dto.setAddress(venueEntity.getAddress());
		dto.setTotalSeats(venueEntity.getTotalSeats());
		dto.setAvailableSeats(venueEntity.getAvailableSeats());
		
		 return dto;
	}
	
	public static VenueEntity toEntity(VenueDTO venueDto) {
		VenueEntity entity= new VenueEntity();
		
		entity.setName(venueDto.getName());
		entity.setAddress(venueDto.getAddress());
		entity.setTotalSeats(venueDto.getTotalSeats());
		entity.setAvailableSeats(venueDto.getAvailableSeats());
		
		 return entity;
	}
}
