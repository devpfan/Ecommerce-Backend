package com.ecommerce.ecommercebackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name="short_description",nullable = false, unique = false)
    private String shortDescription;

    @Column(name="long_description")
    private String longDescription;

    @Column(nullable = false)
    private Double price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    private Inventory inventory;

}
