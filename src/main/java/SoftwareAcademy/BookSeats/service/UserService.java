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
		
		UserDTO firstUser=new UserDTO();
		UserDTO secondUser=new UserDTO();
		
		firstUser.setUserId(12L);
		firstUser.setFirstName("Alex");
		firstUser.setLastName("Stanciu");
		firstUser.setEmail("alexst@alex");
		firstUser.setPassword("1234");
		firstUser.setUsername("alexst1910");
		
		secondUser.setUserId(13L);
	    secondUser.setFirstName("Ion");
		secondUser.setLastName("Popescu");
		secondUser.setEmail("ion@ion");
		secondUser.setPassword("666");
		secondUser.setUsername("ion_popescu");
		
		users.add(firstUser);
		users.add(secondUser);
	}
	
	public List<UserDTO> getUsers() {
		return users;
	}
	
	public void addUser(UserDTO user) {
		users.add(user);
		
		}

	public Boolean deleteUser(Long id) {
		return users.removeIf(user -> user.getUserId() == id);	
		}
}
