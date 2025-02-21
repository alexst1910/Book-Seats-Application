package SoftwareAcademy.BookSeats.converter;

import SoftwareAcademy.BookSeats.dto.UserDTO;
import SoftwareAcademy.BookSeats.entity.UserEntity;

public class UserConverter {

	public static UserDTO toDto(UserEntity userEntity) {
		UserDTO dto= new UserDTO();
		dto.setFirstName(userEntity.getFirstName());
		dto.setLastName(userEntity.getLastName());
		dto.setEmail(userEntity.getEmail());
		dto.setPassword(userEntity.getPassword());
		dto.setUsername(userEntity.getUsername());
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
