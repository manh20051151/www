package com.example.week02_lab_nguyenvietmanh_20051151.backend.business;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orderdetail", schema = "week02", catalog = "")
public class OrderdetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "detailId")
    private long detailId;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "quantity")
    private Double quantity;
    @Basic
    @Column(name = "orderId")
    private Long orderId;
    @Basic
    @Column(name = "productId")
    private Long productId;

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
        OrderdetailEntity that = (OrderdetailEntity) o;
        return detailId == that.detailId && Objects.equals(note, that.note) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity) && Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailId, note, price, quantity, orderId, productId);
    }
}
