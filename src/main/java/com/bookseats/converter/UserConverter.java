package com.bookseats.converter;

import com.bookseats.dto.UserDTO;
import com.bookseats.entity.UserEntity;

public class UserConverter {
	
	
	
	public static UserDTO toDtoWithBookingsAndVenue(UserEntity userEntity) {
		
		UserDTO dto=toDto(userEntity);
		dto.setBookings(userEntity.getBookings().stream().map(bookingEntity -> BookingConverter.toDtoWithVenue(bookingEntity, false)).toList());
		
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
		dto.setRole(userEntity.getRole());
		
		
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
	

}
