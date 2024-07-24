package com.example.CustomerApi.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
public class UserCreationDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private String idNo;
    private String email;
}
