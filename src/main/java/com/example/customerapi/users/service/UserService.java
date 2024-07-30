package com.example.customerapi.users.service;

import com.example.customerapi.users.dto.UserCreationDto;
import com.example.customerapi.users.dto.UserFetchDto;
import com.example.customerapi.users.model.User;
import com.example.customerapi.users.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

        List<UserFetchDto> dtos = new ArrayList<>();
        for (User u : allUsers) {
            UserFetchDto dto = convertToDto(u);
            dtos.add(dto);
        }
        return dtos;
    }

    public User getUserByIdOrElseThrow(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException(String.format("User with id %d not found", userId));
        }
    }


    public UserFetchDto getUserById(Integer userId) {
        User user = getUserByIdOrElseThrow(userId);
        return convertToDto(user);
    }


    public void updateUser(UserCreationDto dto, Integer userId) {
        User user = getUserByIdOrElseThrow(userId);
        if (user == null) {
            return;
        }
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        user.setIdNo(dto.getIdNo());
        userRepository.save(user);
    }

    public static UserFetchDto convertToDto(User u) {
        UserFetchDto dto = new UserFetchDto();
        dto.setFirstName(u.getFirstName());
        dto.setLastName(u.getLastName());
        dto.setAge(u.getAge());
        dto.setEmail(u.getEmail());
        dto.setIdNo(u.getIdNo());
        dto.setId(u.getId());
        return dto;
    }

    public void deleteUserById(Integer userId) {
        User user = getUserByIdOrElseThrow(userId);
        userRepository.delete(user);
    }
}

