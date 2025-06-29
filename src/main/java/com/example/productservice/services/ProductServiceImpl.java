package com.example.productservice.services;

import com.example.productservice.dtos.ImageDto;
import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.models.ProductImage;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Product createProduct(ProductRequestDto productRequestDto) {
        List<ProductImage> productImages = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        for(String categoryStr : productRequestDto.getCategories()){
            Optional<Category> categoryOptional=categoryRepository.findByName(categoryStr);
            if(categoryOptional.isEmpty()){
                Category category=new Category();
                category.setName(categoryStr);
                category.setCreatedAt(new Date());
                categories.add(category);
                categoryRepository.save(category);
            }else{
                categories.add(categoryOptional.get());
            }
        }
        Product product=new Product();
        for(ImageDto productImageDto : productRequestDto.getImageUrls()) {
            ProductImage productImage=new ProductImage();
            productImage.setUrl(productImageDto.getImageUrl());
            productImage.setCreatedAt(new Date());
            productImage.setProduct(product);
            productImages.add(productImage);
        }

        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setImages(productImages);
        product.setCategories(categories);
        product.setImages(productImages);
        product.setPrice(productRequestDto.getPrice());
        product.setCreatedAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductRequestDto productRequestDto) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }


    @Override
    public List<Product> getAllProductsBySearch(String  query) {
        return productRepository.findProductByNameContainingOrDescriptionContaining(query,query);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
