package com.bernardo.lizzie.serviceimpl;

import com.bernardo.lizzie.entity.Product;
import com.bernardo.lizzie.repository.ProductRepository;
import com.bernardo.lizzie.service.ProductService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo;

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product create(Product p) {
        return repo.save(p);
    }
}
