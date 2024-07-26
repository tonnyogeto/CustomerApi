package com.example.customerapi.users.controller;

import com.example.customerapi.users.dto.UserCreationDto;
import com.example.customerapi.users.dto.UserFetchDto;
import com.example.customerapi.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody UserCreationDto dto
    ) {
        userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    @GetMapping
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

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(
            @PathVariable("userId") Integer userId,
            @RequestBody UserCreationDto dto
    ){
        userService.updateUser(dto, userId);
        return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(
            @PathVariable("userId") Integer userId
    ){
        userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }


}