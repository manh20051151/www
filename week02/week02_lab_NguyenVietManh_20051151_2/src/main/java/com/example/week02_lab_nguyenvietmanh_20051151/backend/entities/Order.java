package com.example.week02_lab_nguyenvietmanh_20051151.backend.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "custId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "empId")
    private Employee employee;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}
