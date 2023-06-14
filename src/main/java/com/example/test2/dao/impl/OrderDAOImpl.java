package com.example.test2.dao.impl;

import com.example.test2.dao.OrderDAO;
import com.example.test2.entity.Board;
import com.example.test2.entity.Order;
import com.example.test2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDAOImpl implements OrderDAO {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderDAOImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order insertOrder(Order order) {
        Order saveOrder = orderRepository.save(order);
        return saveOrder;
    }

    @Override
    public List<Order> listOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> listOrderByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Order> listOrderByProductId(Long productId) {
        return orderRepository.findByProductId(productId);
    }

    @Override
    public Optional<Order> listOrderById(Long id) {
        return orderRepository.findById(id);
    }
}
