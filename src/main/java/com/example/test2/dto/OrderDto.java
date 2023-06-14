package com.example.test2.dto;

import com.example.test2.entity.Board;
import com.example.test2.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto {

    private long id;

    private long productId;

    private String productName;

    private long userId;

    private String userName;

    private int price;

    public OrderDto(Order order) {
        this(order.getId(), order.getProductId(), order.getProductName(), order.getUserId(), order.getUserName(), order.getPrice());
    }
}
