package com.example.test2.dto;

import com.example.test2.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardListDto {

    private  Long id;

    private String userId;

    private String userName;

    private String title;

    private String contents;

    public BoardListDto(Board board) {
        this(board.getId(), board.getUserId(), board.getUserName(), board.getTitle(), board.getContents());
    }
}
