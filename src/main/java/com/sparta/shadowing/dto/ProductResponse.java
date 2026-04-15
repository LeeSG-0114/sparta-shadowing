package com.sparta.shadowing.dto;

import com.sparta.shadowing.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ProductResponse {

    private final Long id;
    private final String name;
    private final Integer price;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
