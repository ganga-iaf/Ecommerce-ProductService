package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductImage extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String url;
}
