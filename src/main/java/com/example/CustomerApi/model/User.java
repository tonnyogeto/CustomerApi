package com.example.CustomerApi.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name="f_name")
    private String firstName;

    @Column(name="l_name")
    private String lastName;

    @Column(name="age")
    private Integer age;

    @Column(name ="id_no")
    private String idNo;

    @Column(name="email")
    private String email;

}