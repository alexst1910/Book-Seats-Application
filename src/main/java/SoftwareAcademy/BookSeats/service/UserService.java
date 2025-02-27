package SoftwareAcademy.BookSeats.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import SoftwareAcademy.BookSeats.converter.UserConverter;
import SoftwareAcademy.BookSeats.dto.LoginDTO;
import SoftwareAcademy.BookSeats.dto.UserDTO;
import SoftwareAcademy.BookSeats.entity.UserEntity;
import SoftwareAcademy.BookSeats.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {

	private UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
		
	}
	
	public List<UserDTO> getUsers() {
		
		return Streamable.of(userRepository.findAll()).map(userEntity -> UserConverter.toDtoWithBookingsAndVenue(userEntity)).toList();
	}
	
	
	public UserDTO getUsersBookings(Long id) {
		UserEntity userEntity=userRepository.findByUserId(id).orElseThrow(()-> new RuntimeException("User not found"));
		
		return UserConverter.toDtoWithBookingsAndVenue(userEntity);
	}
	
	// this is available for the user register in FE
	public UserDTO addUser(UserEntity user) {
		
		// set the user role by default
		if(user.getRole()==null) {
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
