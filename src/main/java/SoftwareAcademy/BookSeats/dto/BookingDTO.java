package SoftwareAcademy.BookSeats.dto;

import java.time.LocalDate;
import java.time.LocalTime;




public class BookingDTO {

	private long bookingId;
	private LocalDate date;
	private LocalTime timeFrom;
	private LocalTime timeTo;
	private Integer seats;
	
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(LocalTime timeFrom) {
		this.timeFrom = timeFrom;
	}
	public LocalTime getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(LocalTime timeTo) {
		this.timeTo = timeTo;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	
	
	
	//private UserDTO user;
	
	
}
