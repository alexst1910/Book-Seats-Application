package SoftwareAcademy.BookSeats.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import SoftwareAcademy.BookSeats.dto.UserDTO;

@Service
public class UserService {

	
	List<UserDTO> users= new ArrayList<UserDTO>();
	
	public UserService() {
		
	}
	
	public List<UserDTO> getUsers() {
		return users;
	}
	
	public void addUser(UserDTO user) {
		users.add(user);
		
		}

//	public Boolean deleteUser(Long id) {
//		return users.removeIf(user -> user.getUserId() == id);	
//		}
}
