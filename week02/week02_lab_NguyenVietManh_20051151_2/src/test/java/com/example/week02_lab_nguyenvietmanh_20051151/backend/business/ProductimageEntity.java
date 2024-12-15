package com.example.week02_lab_nguyenvietmanh_20051151.backend.business;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "productimage", schema = "week02", catalog = "")
public class ProductimageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "imageId")
    private long imageId;
    @Basic
    @Column(name = "alternative")
    private String alternative;
    @Basic
    @Column(name = "path")
    private String path;
    @Basic
    @Column(name = "productId")
    private Long productId;

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        ProductimageEntity that = (ProductimageEntity) o;
        return imageId == that.imageId && Objects.equals(alternative, that.alternative) && Objects.equals(path, that.path) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, alternative, path, productId);
    }
}
