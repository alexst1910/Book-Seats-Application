package SoftwareAcademy.BookSeats.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class BookingDTO {

	private long bookingId;
	private LocalDate date;
	private LocalTime timeFrom;
	private LocalTime timeTo;
	private Integer seats;
	//private UserDTO user;
	
	
}
