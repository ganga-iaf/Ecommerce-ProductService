package com.example.productservice.dtos;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.models.ProductImage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductResponseDto {
    private long id;
    private String name;
    private String description;
    private double price;
    private List<ImageDto> images;
    private List<String> categories;

    public static ProductResponseDto fromProduct(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        List<String> categories=new ArrayList<>();
        for (Category category : product.getCategories()) {
            categories.add(category.getName());
        }
        productResponseDto.setCategories(categories);
        List<ImageDto> images=new ArrayList<>();
        for(ProductImage productImage : product.getImages()) {
            ImageDto imageDto=new ImageDto();
            imageDto.setImageUrl(productImage.getUrl());
            imageDto.setAltText("Alt Text");
            images.add(imageDto);
        }
        productResponseDto.setImages(images);
        return productResponseDto;
    }
}
