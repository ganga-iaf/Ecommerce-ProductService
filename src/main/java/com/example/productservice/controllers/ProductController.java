package com.example.productservice.controllers;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.dtos.ProductResponseDto;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping()
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return ProductResponseDto.fromProduct(productService.createProduct(productRequestDto));
    }

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products=productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product:products){
            productResponseDtos.add(ProductResponseDto.fromProduct(product));
        }
        return productResponseDtos;
    }

    @GetMapping("/search/{query}")
    public List<ProductResponseDto> searchProducts(@PathVariable("query") String query) {
        List<Product> products=productService.getAllProductsBySearch(query);
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product:products){
            productResponseDtos.add(ProductResponseDto.fromProduct(product));
        }
        return productResponseDtos;
    }
}
