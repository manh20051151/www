package com.example.week05_lab_NguyenVietManh_20051151.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String about;
    private String compName;
    private String email;
    private String phone;
    private String webUrl;
    @ManyToOne
    @JoinColumn(name = "address")
    private Address address;

//    @OneToOne
//    @JoinColumn(name = "account_id", nullable = false)
//    private Account account;

    @OneToOne(mappedBy = "company")
    private Account account;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
}
