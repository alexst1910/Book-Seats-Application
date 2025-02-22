package SoftwareAcademy.BookSeats.dto;

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
	
	//private RoleDTO role;
	private List<BookingDTO> bookings;
	

	
}