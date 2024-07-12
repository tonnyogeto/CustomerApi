package com.example.CustomerApi.controller;

import com.example.CustomerApi.dto.UserLocationDTO;
import com.example.CustomerApi.model.User;
import com.example.CustomerApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("details")
//    public List<UserLocationDTO> getUserLocation(){
//        return userService.getUserLocation();
//
//    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}