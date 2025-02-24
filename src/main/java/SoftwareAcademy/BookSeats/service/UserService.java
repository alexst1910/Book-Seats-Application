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
		return Streamable.of(userRepository.findAll()).map(userEntity -> UserConverter.toDtoWithBookings(userEntity)).toList();
	}
	
	public List<UserDTO> getAllByFirstNameContaining(String firstName){
		return Streamable.of(userRepository.findAllByFirstNameContaining(firstName)).map(userEntity -> UserConverter.toDto(userEntity)).toList();
	}
	
	public void login(UserDTO userDTO) {
		
		Optional<UserEntity> userOptional = userRepository.findByUsername(userDTO.getUsername());

        if (userOptional.isPresent()) {
             
         System.out.println("Login Successful!");
        }
       
		
	}
	
	public void addUser(UserDTO user) {
		
		UserEntity userEntity=UserConverter.toEntity(user);
		userRepository.save(userEntity);
		
		}

	public void deleteUserById(Long id) {
			userRepository.deleteById(id);
		}
}
