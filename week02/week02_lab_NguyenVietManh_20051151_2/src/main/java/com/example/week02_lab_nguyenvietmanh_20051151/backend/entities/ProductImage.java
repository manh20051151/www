package com.example.week02_lab_nguyenvietmanh_20051151.backend.entities;

import jakarta.persistence.*;

@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String alternative;
    private String path;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
