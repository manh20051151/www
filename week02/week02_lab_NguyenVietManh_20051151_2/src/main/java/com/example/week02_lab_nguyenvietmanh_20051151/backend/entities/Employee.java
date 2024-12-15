package com.example.week02_lab_nguyenvietmanh_20051151.backend.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String address;
    private Date dob;
    private String email;
    private String fullName;
    private String phone;
    private Integer status;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;
}
