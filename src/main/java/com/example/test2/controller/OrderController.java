package com.example.test2.controller;

import com.example.test2.dto.BoardListDto;
import com.example.test2.dto.OrderDto;
import com.example.test2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.saveOrder(orderDto));
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderDto>> listOrder() {
        List <OrderDto> orderDto = orderService.listOrder();
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    @GetMapping("/listByUserId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderDto>> listOrderByUserId(Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.listOrderByUserId(userId));
    }

    @GetMapping("/listByProductId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderDto>> listOrderByProductId(Long productId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.listOrderByProductId(productId));
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderDto>> listOrderById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.listOrderById(id));
    }
}
