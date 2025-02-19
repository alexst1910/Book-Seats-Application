package SoftwareAcademy.BookSeats.service;

import SoftwareAcademy.BookSeats.dto.UserDTO;

public interface UserServiceInterface {

	public void save(UserDTO userDTO);
	public void update(UserDTO userDTO);
	
	// public List<UserDTO> getAllUsers();
}
