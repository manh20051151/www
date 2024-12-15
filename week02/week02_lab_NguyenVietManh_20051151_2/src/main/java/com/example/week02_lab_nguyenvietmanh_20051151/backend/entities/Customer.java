package com.example.week02_lab_nguyenvietmanh_20051151.backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;
    private String address;
    private String email;
    private String custName;
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer() {
    }
}
