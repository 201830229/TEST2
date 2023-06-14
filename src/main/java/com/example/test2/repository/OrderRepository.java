package com.example.test2.repository;

import com.example.test2.entity.Board;
import com.example.test2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);
    List<Order> findByProductId(Long productId);
}
