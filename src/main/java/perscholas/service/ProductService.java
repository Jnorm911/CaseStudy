package perscholas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perscholas.database.dao.ProductDAO;
import perscholas.database.entity.Billing;
import perscholas.database.entity.Product;

import java.util.List;

@Service
public class ProductService {
    private final ProductDAO repo;
    @Autowired
    public ProductService(ProductDAO repo) {
        this.repo = repo;
    }

    public Product get(Integer id) {
        return repo.findById(id).get();
    }

    public void save(Product details) {
        repo.save(details);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
