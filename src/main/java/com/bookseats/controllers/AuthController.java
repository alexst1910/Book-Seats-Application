package com.bookseats.controllers;

import com.bookseats.dto.LoginDTO;
import com.bookseats.entity.UserEntity;
import com.bookseats.response.LoginResponse;
import com.bookseats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> addUser(@RequestBody UserEntity user) {

        LoginResponse newUser = userService.addUser(user);
        Map<String, Object> response = new HashMap<>();

        response.put("message", "user saved");

        return ResponseEntity.ok(response).status(newUser.getStatusCode()).body(newUser);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO login) {

        LoginResponse loginResponse = userService.login(login);

        Map<String, String> response = new HashMap<>();
        response.put("messsage", "logged in");

        return ResponseEntity.ok(response).status(loginResponse.getStatusCode()).body(loginResponse);

    }
}
