package com.bookseats.dto;

import java.util.List;

import lombok.Data;



@Data
public class VenueDTO {
	
	private Long venueId;
	private String name;
	private String address;
	private Integer totalSeats;
	private Integer availableSeats;
	private String cover;
	private List<BookingDTO> bookings;
	
	
	
}
