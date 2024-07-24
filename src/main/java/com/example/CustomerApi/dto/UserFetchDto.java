package com.example.CustomerApi.dto;

import lombok.Data;

@Data
public class UserFetchDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String idNo;
    private String email;

}
