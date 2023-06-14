package com.example.test2.repository;

import com.example.test2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByPriceDesc();
    List<Product> findByName(String name);

}
