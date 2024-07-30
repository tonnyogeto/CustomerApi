package com.example.customerapi.locations.dto;

import com.example.customerapi.users.dto.UserFetchDto;
import com.example.customerapi.users.model.User;
import lombok.Data;

@Data
public class LocationFetchDto {
    private String country;
    private String county;
    private String town;
    private String postalAddress;
    private UserFetchDto user;
}
