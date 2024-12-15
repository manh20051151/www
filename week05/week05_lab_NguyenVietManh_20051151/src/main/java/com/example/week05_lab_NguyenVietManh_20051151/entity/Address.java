package com.example.week05_lab_NguyenVietManh_20051151.entity;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String zipcode;
    private String street;
    @Enumerated(EnumType.STRING)
    private CountryCode country;
    private String number;

    @OneToMany(mappedBy = "address")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "address")
    private List<Company> companies;
}
