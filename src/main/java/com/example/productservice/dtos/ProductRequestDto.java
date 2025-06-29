package com.example.productservice.dtos;

import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private String description;
    private Double price;
    private List<String> categories;
    private List<ImageDto> imageUrls;
}


