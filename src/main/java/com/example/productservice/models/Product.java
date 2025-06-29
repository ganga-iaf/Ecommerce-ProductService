package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String description;
    private double price;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductImage> images=new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "categories_products",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<Category> categories;

    public void addImage(ProductImage productImage){
        images.add(productImage);
    }
}


