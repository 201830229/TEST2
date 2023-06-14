package com.example.test2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChangeProductDto {

    private Long number;
    private String name;
    private int price;
    private int stock;
}
