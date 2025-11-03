package com.bernardo.lizzie.service;

import com.bernardo.lizzie.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product create(Product p);
}
