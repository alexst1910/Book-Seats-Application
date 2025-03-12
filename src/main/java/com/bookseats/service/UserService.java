package com.bookseats.service;

import java.util.List;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.bookseats.converter.UserConverter;
import com.bookseats.dto.LoginDTO;
import com.bookseats.dto.UserDTO;
import com.bookseats.entity.UserEntity;
import com.bookseats.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
		
	}
	
	public List<UserDTO> getUsers() {
		
		return Streamable.of(userRepository.findAll()).map(userEntity -> UserConverter.toDtoWithBookingsAndVenue(userEntity)).toList();
	}
	
	
	// helps displaying all bookings from a user
	public UserDTO getUsersBookings(Long id) {
		
		UserEntity userEntity=userRepository.findByUserId(id).orElseThrow(()-> new RuntimeException("User not found"));
		
		return UserConverter.toDtoWithBookingsAndVenue(userEntity);
	}
	
	
	public UserDTO addUser(UserEntity user) {
		
		// set the user role by default
		if (user.getRole() == null) {
			user.setRole("USER");
		}
		
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException(user.getEmail() + "already exists");
		}
		
		userRepository.save(user);
		return UserConverter.toDto(user);
		
		}
	
	public UserDTO login(LoginDTO login) {
		
		UserEntity user=userRepository.findByEmail(login.getEmail()).orElseThrow(()-> new RuntimeException("user doesn't exist"));
			
		return UserConverter.toDto(user);
	}

	public void deleteUserById(Long id) {
			userRepository.deleteById(id);
		}
}
