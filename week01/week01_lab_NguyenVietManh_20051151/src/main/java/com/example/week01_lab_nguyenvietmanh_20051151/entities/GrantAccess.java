package com.example.week01_lab_nguyenvietmanh_20051151.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grant_access")
public class GrantAccess implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Id
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "is_grant", nullable = false)
    private boolean isGrant;

    @Column(name = "note", length = 250)
    private String note;

    // Getters and Setters
}