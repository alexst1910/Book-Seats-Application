package com.bookseats.service;

import java.util.List;

import com.bookseats.response.LoginResponse;
import com.bookseats.utils.JwtUtils;
import io.jsonwebtoken.Jwt;
import org.hibernate.mapping.UserDefinedArrayType;
import org.springframework.data.util.Streamable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookseats.converter.UserConverter;
import com.bookseats.dto.LoginDTO;
import com.bookseats.dto.UserDTO;
import com.bookseats.entity.UserEntity;
import com.bookseats.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils=jwtUtils;


    }

    public List<UserDTO> getUsers() {

        return Streamable.of(userRepository.findAll()).map(userEntity -> UserConverter.toDtoWithBookingsAndVenue(userEntity)).toList();
    }

    // getting the current user after registration/log in
    public UserDTO getCurrentUser(UserDetails userDetails){

        System.out.println("current user: " + userDetails.getUsername());
        UserEntity user=userRepository.findByUsername(userDetails.getUsername()).orElseThrow(()-> new RuntimeException("User not found"));
        return UserConverter.toDto(user);

    }

    // helps displaying all bookings from a user
    public UserDTO getUsersBookings(Long id) {

        UserEntity userEntity = userRepository.findByUserId(id).orElseThrow(() -> new RuntimeException("User not found"));

        return UserConverter.toDtoWithBookingsAndVenue(userEntity);
    }


    public LoginResponse addUser(UserEntity user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException(user.getEmail() + " already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // set the user role by default
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        userRepository.save(user);

        String token = jwtUtils.generateToken(user);
        return new LoginResponse(UserConverter.toDto(user), token, 200);
    }

    public LoginResponse login(LoginDTO login) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        UserEntity user = userRepository.findByUsername(login.getUsername()).orElseThrow(() -> new RuntimeException("user doesn't exist"));

        String token = jwtUtils.generateToken(user);

        return new LoginResponse(UserConverter.toDto(user), token, 200);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
