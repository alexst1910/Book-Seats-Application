package SoftwareAcademy.BookSeats.converter;

import java.util.ArrayList;
import java.util.List;

import SoftwareAcademy.BookSeats.dto.BookingDTO;
import SoftwareAcademy.BookSeats.dto.UserDTO;
import SoftwareAcademy.BookSeats.entity.BookingEntity;
import SoftwareAcademy.BookSeats.entity.UserEntity;

public class UserConverter {
	
	public static UserDTO toDtoWithBookings(UserEntity userEntity) {
		UserDTO dto=toDto(userEntity);
		dto.setBookings(userEntity.getBookings().stream().map(bookingEntity -> BookingConverter.toDto(bookingEntity)).toList());
		
		return dto;
	}

	public static UserDTO toDto(UserEntity userEntity) {
		UserDTO dto= new UserDTO();
		dto.setUserId(userEntity.getUserId());
		dto.setFirstName(userEntity.getFirstName());
		dto.setLastName(userEntity.getLastName());
		dto.setEmail(userEntity.getEmail());
		dto.setPassword(userEntity.getPassword());
		dto.setUsername(userEntity.getUsername());
		
//		if(userEntity.getBookings()!= null) {
//			dto.setBookings(bookingEntitiesToDto(userEntity.getBookings()));
//		}
		
		 return dto;
		 
	}
	
	public static UserEntity toEntity(UserDTO userDto) {
		UserEntity entity =new UserEntity();
		
		entity.setFirstName(userDto.getFirstName());
		entity.setLastName(userDto.getLastName());
		entity.setEmail(userDto.getEmail());
		entity.setPassword(userDto.getPassword());
		entity.setUsername(userDto.getUsername());

		return entity;
	}
	
//	private static List<BookingDTO> bookingEntitiesToDto(List<BookingEntity> bookingEntities){
//		
//		List<BookingDTO> bookingDTOs =new ArrayList<>();
//		for(BookingEntity bookingEntity : bookingEntities) {
//			bookingDTOs.add(BookingConverter.toDto(bookingEntity));
//		}
//		
//		return bookingDTOs;
//	}
//	
//private static List<BookingEntity> bookingDTOsToEntities(List<BookingDTO> bookingDTOs){
//		
//		List<BookingEntity> bookingEntities =new ArrayList<>();
//		for(BookingDTO bookingDTO : bookingDTOs) {
//			bookingEntities.add(BookingConverter.toEntity(bookingDTO));
//		}
//		
//		return bookingEntities;
//	}
}
