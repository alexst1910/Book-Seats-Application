package SoftwareAcademy.BookSeats.converter;

import SoftwareAcademy.BookSeats.dto.BookingDTO;
import SoftwareAcademy.BookSeats.dto.UserDTO;
import SoftwareAcademy.BookSeats.entity.BookingEntity;
import SoftwareAcademy.BookSeats.entity.UserEntity;

public class BookingConverter {

	public static BookingDTO toDto(BookingEntity bookingEntity) {
		BookingDTO dto= new BookingDTO();
		
		dto.setDate(bookingEntity.getDate());
		dto.setTimeFrom(bookingEntity.getTimeFrom());
		dto.setTimeTo(bookingEntity.getTimeTo());
		dto.setSeats(bookingEntity.getSeats());
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
