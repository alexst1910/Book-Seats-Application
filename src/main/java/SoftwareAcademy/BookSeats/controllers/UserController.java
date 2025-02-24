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

import SoftwareAcademy.BookSeats.dto.UserDTO;
import SoftwareAcademy.BookSeats.entity.UserEntity;
import SoftwareAcademy.BookSeats.service.UserService;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/allUsers")
	public List<UserDTO> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/allUsersByFirstName/{first-name}")
	public List<UserDTO> getAllByFirstnameContaining(@PathVariable("first-name") String firstName) {
		return userService.getAllByFirstNameContaining(firstName);
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserDTO user) {
		userService.addUser(user);
		return "user has been saved";
		
		}
	
	@PostMapping("/login")
	public void login(@RequestBody UserDTO userDTO) {
		
		userService.login(userDTO);
		
		
	}
	
	@PostMapping("/registerUser")
	public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserDTO user) {
	    userService.addUser(user);

	   
	    Map<String, Object> response = new HashMap<>();
	    response.put("message", "User created successfully");
	    response.put("user", user); 

	   
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	@DeleteMapping("/deleteUserById/{id}")
	public Boolean deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return true;	}
}


