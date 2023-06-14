package com.example.test2.dao;

import com.example.test2.entity.Board;
import com.example.test2.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    Order insertOrder(Order order);
    List<Order> listOrder();
    List<Order> listOrderByUserId(Long userId);
    List<Order> listOrderByProductId(Long productId);
    Optional<Order> listOrderById(Long id);
}
