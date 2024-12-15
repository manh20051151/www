package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class ProductPrice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int priceId;
    @ManyToOne @JoinColumn(name = "productId")
    private Product product;
    private double price;
    private Date appliedDate;

    public ProductPrice() {

    }

    public ProductPrice(int priceId, Product product, double price, Date appliedDate) {
        this.priceId = priceId;
        this.product = product;
        this.price = price;
        this.appliedDate = appliedDate;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductPrice that = (ProductPrice) o;
        return priceId == that.priceId;
    }

    @Override
    public int hashCode() {
        return priceId;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceId=" + priceId +
                ", product=" + product +
                ", price=" + price +
                ", appliedDate=" + appliedDate +
                '}';
    }
}
