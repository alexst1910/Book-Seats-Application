package SoftwareAcademy.BookSeats.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Streamable;
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
		return Streamable.of(userRepository.findAll()).map(userEntity -> UserConverter.toDto(userEntity)).toList();
	}
	
	
	public void addUser(UserDTO user) {
		
		UserEntity userEntity=UserConverter.toEntity(user);
		userRepository.save(userEntity);
		
		}

	public void deleteUserById(Long id) {
			userRepository.deleteById(id);
		}
}
