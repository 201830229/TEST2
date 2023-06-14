package com.example.test2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {
    private String userId;

    private String userName;

    private String title;

    private String contents;

}
