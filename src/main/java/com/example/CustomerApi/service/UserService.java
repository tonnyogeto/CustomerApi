package com.example.CustomerApi.service;

import com.example.CustomerApi.dto.UserCreationDto;
import com.example.CustomerApi.dto.UserFetchDto;
import com.example.CustomerApi.model.User;
import com.example.CustomerApi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public void createUser(UserCreationDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        user.setIdNo(dto.getIdNo());
        userRepository.save(user);
    }

    public List<UserFetchDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();

        List<UserFetchDto> dtos =new ArrayList<>();
        for (User u : allUsers) {
            UserFetchDto dto = convertToDto(u);
            dtos.add(dto);
        }
        return dtos;
    }

    public  UserFetchDto getUserById(Integer userId){
       Optional<User> userOptional = userRepository.findById(userId);
       if(userOptional.isPresent()){
           User user = userOptional.get();

       }
    }

    private static UserFetchDto convertToDto(User u) {
        UserFetchDto dto = new UserFetchDto();
        dto.setFirstName(u.getFirstName());
        dto.setLastName(u.getLastName());
        dto.setAge(u.getAge());
        dto.setEmail(u.getEmail());
        dto.setIdNo(u.getIdNo());
        dto.setId(u.getId());
        return dto;
    }
}

