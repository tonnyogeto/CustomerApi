package com.example.CustomerApi.controller;

import com.example.CustomerApi.dto.UserCreationDto;
import com.example.CustomerApi.dto.UserFetchDto;
import com.example.CustomerApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(
            @RequestBody UserCreationDto dto
    ) {
        userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
       List<UserFetchDto> users= userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserById(
            @PathVariable("userId") Integer userId
    ) {
        UserFetchDto dto = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}