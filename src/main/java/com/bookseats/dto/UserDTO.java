package com.bookseats.dto;

import java.util.List;

import lombok.Data;



@Data
public class UserDTO {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private String role;
	
	//private RoleDTO role;
	private List<BookingDTO> bookings;
	

	
}