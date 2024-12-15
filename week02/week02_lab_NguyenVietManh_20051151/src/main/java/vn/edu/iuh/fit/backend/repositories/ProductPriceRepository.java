package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.entities.ProductPrice;

import java.util.List;

public class ProductPriceRepository {
    @PersistenceContext(unitName = "my_pu")
    private EntityManager entityManager;
    public void save(ProductPrice productPrice) {
        entityManager.persist(productPrice);
    }
    public ProductPrice findById(Long id) {
        return entityManager.find(ProductPrice.class, id);
    }
    public List<ProductPrice> findAll() {
        return entityManager.createQuery("select  p from ProductPrice p", ProductPrice.class).getResultList();
    }
    public void delete(ProductPrice productPrice) {
        entityManager.remove(productPrice);
    }
    public void update(ProductPrice productPrice) {
        entityManager.merge(productPrice);
    }
}
