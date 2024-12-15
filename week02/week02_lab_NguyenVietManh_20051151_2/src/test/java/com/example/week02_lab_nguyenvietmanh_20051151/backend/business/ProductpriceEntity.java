package com.example.week02_lab_nguyenvietmanh_20051151.backend.business;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "productprice", schema = "week02", catalog = "")
public class ProductpriceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "priceId")
    private long priceId;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "priceDateTime")
    private Timestamp priceDateTime;
    @Basic
    @Column(name = "productId")
    private Long productId;

    public long getPriceId() {
        return priceId;
    }

    public void setPriceId(long priceId) {
        this.priceId = priceId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(Timestamp priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductpriceEntity that = (ProductpriceEntity) o;
        return priceId == that.priceId && Objects.equals(note, that.note) && Objects.equals(price, that.price) && Objects.equals(priceDateTime, that.priceDateTime) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceId, note, price, priceDateTime, productId);
    }
}
