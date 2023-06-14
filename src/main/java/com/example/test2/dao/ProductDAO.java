package com.example.test2.dao;

import com.example.test2.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    Product selectProduct(Long number);
    Product changeProduct(Long number, String name, int price, int stock) throws Exception;
    Product insertProduct(Product product);
    void deleteProduct(Long number) throws Exception;
    List<Product> listProduct();
    List<Product> listProductByPrice();
    List<Product> listProductByName(String name);
    Optional<Product> listProductById(Long number);
}
