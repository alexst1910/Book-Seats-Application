package SoftwareAcademy.BookSeats.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class BookingDTO {

	private Long bookingId;
	private LocalDate date;
	private LocalTime timeFrom;
	private LocalTime timeTo;
	private Integer seats;
	@JsonProperty(value="user")
	private UserDTO user;
	@JsonProperty(value="venue")
	private VenueDTO venue;
	
	
	

	
	
}
