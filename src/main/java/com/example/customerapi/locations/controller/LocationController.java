package com.example.customerapi.locations.controller;

import com.example.customerapi.locations.dto.LocationCreationDto;
import com.example.customerapi.locations.dto.LocationFetchDto;
import com.example.customerapi.locations.service.LocationService;
import com.example.customerapi.users.dto.UserCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping
    public ResponseEntity<?> getLocations(){
        List<LocationFetchDto> locations = locationService.getLocations();
        return ResponseEntity.status(HttpStatus.OK).body(locations);
    }

    @PostMapping
    public ResponseEntity<?> createLocation(
            @RequestBody LocationCreationDto dto
    ){
        locationService.createLocation(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("successfully created");
    }

    @PutMapping("/{locationId}")
    public ResponseEntity<?> updateLocationById(
            @PathVariable Integer locationId,
            @RequestBody LocationCreationDto dto

    ){
        locationService.updateLocationById(dto,locationId);
        return ResponseEntity.status(HttpStatus.OK).body("updated successfully");
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<?> deleteLocationById(
            @PathVariable Integer locationId
    ){
        locationService.deleteLocationById(locationId);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }
}
