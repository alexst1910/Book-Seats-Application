package SoftwareAcademy.BookSeats.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import SoftwareAcademy.BookSeats.dto.UserDTO;
import SoftwareAcademy.BookSeats.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	
	public void addUser(UserDTO user) {
		
		
		}

//	public Boolean deleteUser(Long id) {
//		return users.removeIf(user -> user.getUserId() == id);	
//		}
}
