package com.example.customerapi.locations.dto;

import com.example.customerapi.users.model.User;
import lombok.Data;

@Data
public class LocationCreationDto {
    private String country;
    private String county;
    private String town;
    private String postalAddress;
    private Integer userId;
}
