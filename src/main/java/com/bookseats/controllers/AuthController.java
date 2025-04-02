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
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody UserEntity user) {
        userService.addUser(user);
        Map<String, Object> response=new HashMap<>();

        response.put("message", "user saved");
        response.put("user", user);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO login) {

        LoginResponse loginResponse=userService.login(login);


        return ResponseEntity.status(loginResponse.getStatusCode()).body(loginResponse);

    }
}
