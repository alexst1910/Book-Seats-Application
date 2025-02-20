package SoftwareAcademy.BookSeats.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
	
	private long userId;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private RoleDTO role;
	private List<BookingDTO> bookings;
	
	
//	public long getUserId() {
//		return userId;
//	}
//	
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}
//	
//	public String getFirstName() {
//		return firstName;
//	} 
//	
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	
//	public String getLastName() {
//		return lastName;
//	}
//	
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	
//	public String getUsername() {
//		return username;
//	}
//	
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	
//	public String getEmail() {
//		return email;
//	}
//	
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public List<BookingDTO> getBookings() {
//		return bookings;
//	}
//
//	public void setBookings(List<BookingDTO> bookings) {
//		this.bookings = bookings;
//	}
	
}