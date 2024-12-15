package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 200)
    private String name;

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;

    @Column(nullable = false, length = 200)
    private String supplierName;

    public Product() {
    }

    public Product(int id, String name, String supplierName) {
        this.id = id;
        this.name = name;
        this.supplierName = supplierName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }
}
