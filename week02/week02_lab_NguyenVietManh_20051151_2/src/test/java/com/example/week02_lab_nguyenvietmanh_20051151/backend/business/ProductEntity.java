package com.example.week02_lab_nguyenvietmanh_20051151.backend.business;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product", schema = "week02", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productId")
    private long productId;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "manufacturerName")
    private String manufacturerName;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "unit")
    private String unit;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId && Objects.equals(description, that.description) && Objects.equals(manufacturerName, that.manufacturerName) && Objects.equals(name, that.name) && Objects.equals(status, that.status) && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, description, manufacturerName, name, status, unit);
    }
}
