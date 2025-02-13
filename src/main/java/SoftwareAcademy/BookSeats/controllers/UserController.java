package SoftwareAcademy.BookSeats.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.UserDTO;
import SoftwareAcademy.BookSeats.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/allUsers")
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserDTO user) {
		userService.addUser(user);
		return "user has been saved";
		
		}
	
	@DeleteMapping("/deleteUserById/{id}")
	public Boolean deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);	}
}


