package com.example.customerapi.locations.model;

import com.example.customerapi.users.model.User;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_sequence_generator")
    @SequenceGenerator(name = "location_sequence_generator", sequenceName = "location_id_seq",allocationSize = 1)
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