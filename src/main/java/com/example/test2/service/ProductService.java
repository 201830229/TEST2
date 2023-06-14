package com.example.test2.service;

import com.example.test2.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProduct(Long number);
    ProductDto changeProduct(Long number, String name, int price, int stock) throws Exception;
    ProductDto saveProduct(ProductDto productDto);
    void deleteProduct(Long number) throws Exception;
    List<ProductDto> listProduct();
    List<ProductDto> listProductByPrice();
    List<ProductDto> listProductByName(String name);
    List<ProductDto> listProductById(Long number);

}
