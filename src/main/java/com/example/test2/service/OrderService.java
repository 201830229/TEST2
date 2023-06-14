package com.example.test2.service;

import com.example.test2.dto.BoardListDto;
import com.example.test2.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto);
    List<OrderDto> listOrder();
    List<OrderDto> listOrderByUserId(Long userId);
    List<OrderDto> listOrderByProductId(Long productId);
    List<OrderDto> listOrderById(Long id);
}
