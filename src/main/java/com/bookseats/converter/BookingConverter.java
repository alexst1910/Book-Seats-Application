package com.bookseats.converter;

import com.bookseats.dto.BookingDTO;
import com.bookseats.dto.VenueDTO;
import com.bookseats.entity.BookingEntity;

public class BookingConverter {

	public static BookingDTO toDto(BookingEntity bookingEntity) {
		BookingDTO dto= new BookingDTO();
		dto.setBookingId(bookingEntity.getBookingId());
		dto.setDate(bookingEntity.getDate());
		dto.setTimeFrom(bookingEntity.getTimeFrom());
		dto.setTimeTo(bookingEntity.getTimeTo());
		dto.setSeats(bookingEntity.getSeats());
		
	
		return dto;
		 
	}
	
	public static BookingDTO toDtoWithVenue(BookingEntity bookingEntity, boolean mapUser) {
		BookingDTO dto= new BookingDTO();
		dto.setBookingId(bookingEntity.getBookingId());
		dto.setDate(bookingEntity.getDate());
		dto.setTimeFrom(bookingEntity.getTimeFrom());
		dto.setTimeTo(bookingEntity.getTimeTo());
		dto.setSeats(bookingEntity.getSeats());
		
		if(mapUser) {
			dto.setUser(UserConverter.toDto(bookingEntity.getUser()));
		}
		
		if(bookingEntity.getVenue()!= null) {
			
			VenueDTO venueDto=new VenueDTO();
			venueDto.setVenueId(bookingEntity.getVenue().getVenueId());
			venueDto.setName(bookingEntity.getVenue().getName());
			venueDto.setAddress(bookingEntity.getVenue().getAddress());
			venueDto.setTotalSeats(bookingEntity.getVenue().getTotalSeats());
			venueDto.setCover(bookingEntity.getVenue().getCover());
			venueDto.setAvailableSeats(bookingEntity.getVenue().getAvailableSeats());
			
			dto.setVenue(venueDto);
			
			
		}
		
		return dto;
	}
	
	public static BookingEntity toEntity(BookingDTO bookingDto) {
		
		BookingEntity entity= new BookingEntity();
	
		entity.setDate(bookingDto.getDate());
	    entity.setTimeFrom(bookingDto.getTimeFrom());
		entity.setTimeTo(bookingDto.getTimeTo());
		entity.setSeats(bookingDto.getSeats());
		
	
		
		return entity;
	}
	
	
}
