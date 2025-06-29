package com.example.productservice.repositories;


import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
      List<Product> findAll();
      List<Product> findProductByNameContainingOrDescriptionContaining(String query,String description);
}
