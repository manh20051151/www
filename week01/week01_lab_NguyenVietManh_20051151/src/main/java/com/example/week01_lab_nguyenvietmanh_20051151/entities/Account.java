package com.example.week01_lab_nguyenvietmanh_20051151.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @Column(name = "account_id", length = 50)
    private String accountId;

    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "status", nullable = false)
    private int status;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GrantAccess> grantAccesses;

    // Getters and Setters
}