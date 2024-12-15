package com.example.week01_lab_nguyenvietmanh_20051151.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "log")
public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "login_time", nullable = false)
    private LocalDateTime loginTime;

    @Column(name = "logout_time", nullable = false)
    private LocalDateTime logoutTime;

    @Column(name = "notes", length = 250, nullable = false)
    private String notes;

    // Getters and Setters
}
