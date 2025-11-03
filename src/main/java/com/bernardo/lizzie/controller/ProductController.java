package com.bernardo.lizzie.controller;

import com.bernardo.lizzie.entity.Product;
import com.bernardo.lizzie.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "{app.client.url")
public class ProductController {
    private final ProductService svc;

    public ProductController(ProductService svc) {
        this.svc = svc;
    }

    @GetMapping
    public ResponseEntity<List<Product>> all() {
        return ResponseEntity.ok(svc.getAll());
    }

    // para sa admin if ever iexpand ko pa itong project nato for now customer side lang muna
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product p) {
        return ResponseEntity.ok(svc.create(p));
    }

}
