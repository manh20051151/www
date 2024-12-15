package com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.repositories;

import com.example.week03_04_lab_nguyenvietmanh_20051151.backend.data.entities.ProductPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;

public class ProductPriceRepository {
    @PersistenceContext(unitName = "teo_pu")
    private EntityManager em;

    public void save(ProductPrice productPrice) {
        em.persist(productPrice);
    }
    public ProductPrice findById(Long id) {
        return em.find(ProductPrice.class, id);
    }

    public ProductPrice findActivePriceOfProduct(Long id) {
        return  em.createNamedQuery("ProductPrice.findActivePriceOfProduct", ProductPrice.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    public List<ProductPrice> findAll() {
        return em.createNamedQuery("ProductPrice.findAll", ProductPrice.class).getResultList();
    }
    public void delete(ProductPrice productPrice) {
        productPrice.setState(0);
        em.merge(productPrice);
    }

}
