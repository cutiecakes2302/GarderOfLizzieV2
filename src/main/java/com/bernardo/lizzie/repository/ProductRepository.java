package com.bernardo.lizzie.repository;

import com.bernardo.lizzie.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
