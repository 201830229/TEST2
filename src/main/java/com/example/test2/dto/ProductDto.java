package com.example.test2.dto;

import com.example.test2.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {

    private Long number;
    private String name;
    private int price;
    private int stock;

    public ProductDto(Product product) {
        this(product.getNumber(), product.getName(), product.getPrice(), product.getStock());
    }
}
