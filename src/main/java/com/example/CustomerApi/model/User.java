package com.example.CustomerApi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int idNo;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;
}