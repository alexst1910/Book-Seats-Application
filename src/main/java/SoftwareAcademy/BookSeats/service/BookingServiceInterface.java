package SoftwareAcademy.BookSeats.service;

import java.util.List;

import SoftwareAcademy.BookSeats.dto.BookingDTO;

public interface BookingServiceInterface {

	public List<BookingDTO> getAllBookings();
	
	public List<BookingDTO> getAllByUser();
	
	public void save(BookingDTO bookingDTO);
	
	public void update(BookingDTO bookingDTO);
	
	public void removeById(Long id);
	
	
}
