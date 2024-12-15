package com.example.week05_lab_NguyenVietManh_20051151.model;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "address")
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

    public Address(long id, String city, String zipcode, String street, CountryCode country, String number, List<Candidate> candidates) {
        this.id = id;
        this.city = city;
        this.zipcode = zipcode;
        this.street = street;
        this.country = country;
        this.number = number;
        this.candidates = candidates;
    }

    public Address() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public CountryCode getCountry() {
        return country;
    }

    public void setCountry(CountryCode country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
