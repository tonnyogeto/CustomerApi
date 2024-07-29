package com.example.customerapi.locations.service;

import com.example.customerapi.locations.dto.LocationCreationDto;
import com.example.customerapi.locations.dto.LocationFetchDto;
import com.example.customerapi.locations.model.Location;
import com.example.customerapi.locations.repository.LocationRepository;
import com.example.customerapi.users.model.User;
import com.example.customerapi.users.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserService userService;

    public List<LocationFetchDto> getLocations() {
        List<Location> locations = locationRepository.findAll();

        List<LocationFetchDto> dtos = new ArrayList<>();
        for (Location l : locations) {
            LocationFetchDto dto = convertToDto(l);
        }
        return dtos;
    }

    private static LocationFetchDto convertToDto(Location l) {
        LocationFetchDto dto = new LocationFetchDto();
        dto.setCountry(l.getCountry());
        dto.setCounty(l.getCounty());
        dto.setTown(l.getTown());
        dto.setPostalAddress(l.getPostalAddress());
        dto.setUser(l.getUser());
        return dto;
    }

    @Transactional
    public void createLocation(LocationCreationDto dto) {
        User user = userService.getUserByIdOrElseThrow(dto.getUserId());
        Location location = new Location();
        location.setCountry(dto.getCountry());
        location.setCounty(dto.getCounty());
        location.setTown(dto.getTown());
        location.setPostalAddress(dto.getPostalAddress());
        location.setUser(user);
        locationRepository.save(location);
    }
}

