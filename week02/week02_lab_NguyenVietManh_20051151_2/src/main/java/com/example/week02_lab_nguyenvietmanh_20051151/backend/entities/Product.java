package com.example.week02_lab_nguyenvietmanh_20051151.backend.entities;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String description;
    private String manufacturerName;
    private String name;
    private Integer status;
    private String unit;

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}
