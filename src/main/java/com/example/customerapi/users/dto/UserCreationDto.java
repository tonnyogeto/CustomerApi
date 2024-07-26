package com.example.customerapi.users.dto;


import lombok.Data;

@Data
public class UserCreationDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String idNo;
    private String email;
}
