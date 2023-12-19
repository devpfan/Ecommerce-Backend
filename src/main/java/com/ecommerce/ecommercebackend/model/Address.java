package com.ecommerce.ecommercebackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name="address_line_1", nullable = false, length = 512)
    private String addressLine1;

    @Column(name="address_line_2", nullable = false, length = 512)
    private String addressLine2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, length = 75)
    private String country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private LocalUser user;
}
