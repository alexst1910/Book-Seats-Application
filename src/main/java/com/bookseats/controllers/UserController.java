package com.bookseats.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookseats.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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


    @GetMapping("/allUsers")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/usersBookings/{id}")
    public ResponseEntity<UserDTO> getUsersBookings(@PathVariable Long id) {

        UserDTO userDto = userService.getUsersBookings(id);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/current")
    public ResponseEntity<UserDTO> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {

        UserDTO currentUser = userService.getCurrentUser(userDetails);

        return ResponseEntity.ok(currentUser);
    }


    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Long id) {

        userService.deleteUserById(id);
        Map<String, Object> response = new HashMap<>();

        response.put("message", "user deleted");

        return ResponseEntity.ok(response);
    }
}


