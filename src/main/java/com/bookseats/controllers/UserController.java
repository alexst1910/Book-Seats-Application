package com.bookseats.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookseats.dto.LoginDTO;
import com.bookseats.dto.UserDTO;
import com.bookseats.entity.UserEntity;
import com.bookseats.service.UserService;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;


	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> addUser(@RequestBody UserEntity user) {
		userService.addUser(user);
		Map<String, Object> response=new HashMap<>();

		response.put("message", "user saved");
		response.put("user", user);
		return ResponseEntity.ok(response);

	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO login) {

		userService.login(login);
		Map<String, Object> response=new HashMap<>();

		response.put("message", "logged in");

		return ResponseEntity.ok(response);

	}

	@GetMapping("/allUsers")
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/usersBookings/{id}")
	public ResponseEntity<UserDTO> getUsersBookings(@PathVariable Long id) {
		
		UserDTO userDto=userService.getUsersBookings(id);
		
		return ResponseEntity.ok(userDto);
	}
	

	

	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Long id) {
		
		userService.deleteUserById(id);
		Map<String, Object> response=new HashMap<>();
		
		response.put("message", "user deleted");
		
		return ResponseEntity.ok(response);
			}
}


