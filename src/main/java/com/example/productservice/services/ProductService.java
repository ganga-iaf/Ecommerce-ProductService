package com.example.productservice.services;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(ProductRequestDto productRequestDto);
    Product updateProduct(ProductRequestDto productRequestDto);
    void deleteProduct(Long productId);
    List<Product> getAllProductsBySearch(String query);
    List<Product> getAllProducts();


}
