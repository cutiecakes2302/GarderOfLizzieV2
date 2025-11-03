package com.bernardo.lizzie.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private int stock;
}
