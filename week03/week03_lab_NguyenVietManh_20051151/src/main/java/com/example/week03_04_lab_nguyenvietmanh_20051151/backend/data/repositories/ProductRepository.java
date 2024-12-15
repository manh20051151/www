package com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.repositories;

import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;

public class ProductRepository {
    @PersistenceContext(unitName = "teo_pu")
    private EntityManager em;

    public void save(Product product) {
        em.persist(product);
    }

    public void delete(Product product) {
        em.remove(product);
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }
    public List<Product> findAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    //....,..
}
