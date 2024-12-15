package vn.edu.iuh.fit.backend.business;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.backend.entities.Product;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;

import java.util.List;

public class ProductBO {
    @Inject
    private ProductRepository productRepository;

    public void save(Product product) {
        productRepository.persist(product);
    }

    public Product getProductById(int id) {
        return productRepository.find(id);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
