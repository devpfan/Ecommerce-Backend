package com.ecommerce.ecommercebackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="local_user")
public class LocalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 1000)
    private String password;

    @Column(nullable = false, unique = true, length = 320)
    public String email;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval=true)
    private List<Address>addresses = new ArrayList<>();



}
