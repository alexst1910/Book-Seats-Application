package SoftwareAcademy.BookSeats.dto;

import java.util.List;

import lombok.Data;

@Data
public class VenueDTO {
	
	private long venueId;
	private String name;
	private String address;
	private Integer totalSeats;
	private Integer availableSeats;
	private List<BookingDTO> bookings;
	
	
	
}
