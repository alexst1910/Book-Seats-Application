package SoftwareAcademy.BookSeats.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SoftwareAcademy.BookSeats.dto.LoginDTO;
import SoftwareAcademy.BookSeats.dto.UserDTO;
import SoftwareAcademy.BookSeats.entity.UserEntity;
import SoftwareAcademy.BookSeats.service.UserService;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/allUsers")
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/usersBokings/{id}")
	public String getUsersBookings(@PathVariable Long id) {
		userService.getUsersBookings(id);
		return "user's Bookings";
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Map<String, Object>> addUser(@RequestBody UserEntity user) {
		userService.addUser(user);
		Map<String, Object> response=new HashMap<>();
		
		response.put("message", "user saved");
		response.put("user", user);
		return ResponseEntity.ok(response);
				
		}
	
	@PostMapping("/login")
	public void login(@RequestBody LoginDTO login) {
		
		userService.login(login);
		
	}
	

	@DeleteMapping("/deleteUserById/{id}")
	public Boolean deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return true;	}
}


