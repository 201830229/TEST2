package com.example.test2.service.impl;

import com.example.test2.dao.OrderDAO;
import com.example.test2.dto.BoardListDto;
import com.example.test2.dto.OrderDto;
import com.example.test2.entity.Board;
import com.example.test2.entity.Order;
import com.example.test2.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setUserId(orderDto.getUserId());
        order.setProductId(orderDto.getProductId());
        order.setProductName(orderDto.getProductName());
        order.setUserId(orderDto.getUserId());
        order.setUserName(orderDto.getUserName());
        order.setPrice(orderDto.getPrice());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order saveOrder = orderDAO.insertOrder(order);

        orderDto.setId(saveOrder.getId());
        orderDto.setProductId(saveOrder.getProductId());
        orderDto.setProductName(saveOrder.getProductName());
        orderDto.setUserId(saveOrder.getUserId());
        orderDto.setUserName(saveOrder.getUserName());
        orderDto.setPrice((saveOrder.getPrice()));
        return orderDto;
    }

    @Override
    public List<OrderDto> listOrder() {
        List<Order> orders = orderDAO.listOrder();
        List<OrderDto> orderDtoList = orders.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        return orderDtoList;
    }

    @Override
    public List<OrderDto> listOrderByUserId(Long userId) {
        List<Order> orders = orderDAO.listOrderByUserId(userId);
        List<OrderDto> orderDtoList = orders.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        return orderDtoList;
    }

    @Override
    public List<OrderDto> listOrderByProductId(Long productId) {
        List<Order> orders = orderDAO.listOrderByProductId(productId);
        List<OrderDto> orderDtoList = orders.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        return orderDtoList;
    }

    @Override
    public List<OrderDto> listOrderById(Long id) {
        Optional<Order> orders = orderDAO.listOrderById(id);
        List<OrderDto> orderDtoList = orders.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        return orderDtoList;
    }
}
