package com.example.CustomerApi.service;

import com.example.CustomerApi.dto.UserLocationDTO;
import com.example.CustomerApi.model.User;
import com.example.CustomerApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
//
//    public List<UserLocationDTO> getUserLocation() {
//        return userRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
//    }
//
//    public UserLocationDTO convertEntityToDto(User user){
//        UserLocationDTO userLocationDTO =new UserLocationDTO();
//        userLocationDTO.setFirstName(user.getFirstName());
//        userLocationDTO.setLastName(user.getLastName());
//        userLocationDTO.setAge(user.getAge());
//        userLocationDTO.setCountry(user.getLocation().getCountry());
//        userLocationDTO.setTown(user.getLocation().getTown());
//
//        return userLocationDTO;
//
//    }

    public ResponseEntity<List<User>> getAllUsers() {
        try{
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);


    }
}

