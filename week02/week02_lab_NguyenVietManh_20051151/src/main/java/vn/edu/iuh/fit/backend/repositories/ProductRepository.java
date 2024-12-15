package vn.edu.iuh.fit.backend.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.entities.Product;

import java.util.List;

@Stateless
public class ProductRepository {
    @PersistenceContext(unitName = "my_pu")
    private EntityManager entityManager;

    public void persist(Product product) {
        entityManager.persist(product);
    }
    public Product find(int id) {
        return entityManager.find(Product.class, id);
    }
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }
    public void delete(Product product) {
        entityManager.remove(product);
    }
    public void update(Product product) {
        entityManager.merge(product);
    }
}
