package com.example.week02_lab_nguyenvietmanh_20051151.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;
    private Date priceDateTime;
    private String note;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
