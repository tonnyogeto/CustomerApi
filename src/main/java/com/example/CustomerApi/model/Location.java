package com.example.CustomerApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_locations")
public class Location {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "country")
    private String country;

    @Column(name = "county")
    private String county;

    @Column(name = "town")
    private String town;

    @Column(name = "postal_address")
    private String postalAddress;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}