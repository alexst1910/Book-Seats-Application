package SoftwareAcademy.BookSeats.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.UserDTO;



@RestController
public class UserController {

	List<UserDTO> users= new ArrayList<UserDTO>();
	
	public UserController() {
		
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
	
	@GetMapping("/allUsers")
	public List<UserDTO> getUsers() {
		return users;
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserDTO user) {
		users.add(user);
		return "user has been saved";
		
		}
	
	@DeleteMapping("/deleteUserById/{id}")
	public Boolean deleteUser(@PathVariable Long id) {
		return users.removeIf(user -> user.getUserId() == id);	}
}

