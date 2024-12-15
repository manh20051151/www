package com.example.week03_04_lab_nguyenvietmanh_20051151.backend.business;

import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.dtos.ProductDTO;
import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.entities.Product;
import jakarta.ejb.Local;


import java.util.List;

@Local
public interface ProductLocal {
    void add(Product product);
//    void update(Product product);
    void delete(Product product);
    ProductDTO getProduct(long id);
    List<ProductDTO> getProducts();
}
