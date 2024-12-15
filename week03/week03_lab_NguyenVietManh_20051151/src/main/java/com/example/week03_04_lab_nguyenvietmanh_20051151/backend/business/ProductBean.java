package com.example.week03_04_lab_nguyenvietmanh_20051151.backend.business;

import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.dtos.ProductDTO;
import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.entities.Product;
import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.repositories.ProductPriceRepository;
import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.repositories.ProductRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;


import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductBean implements ProductLocal{
    @Inject

    private ProductRepository productRepository;

    @Inject

    private ProductPriceRepository productPriceRepository;

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public ProductDTO getProduct(long id) {
        Product product = productRepository.findById(id);
        Double price = productPriceRepository.findActivePriceOfProduct(id).getValue();
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImgPath(),
                price
        );
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO>dtos= new ArrayList<>();
        for (Product product : products) {
            Double price = productPriceRepository.findActivePriceOfProduct(product.getId()).getValue();
            ProductDTO productDto = new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getImgPath(),
                    price
            );
            dtos.add(productDto);
        }
        return dtos;
    }
}
