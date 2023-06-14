package com.example.test2.service;


import com.example.test2.dto.BoardDto;
import com.example.test2.dto.BoardListDto;
import com.example.test2.dto.ChangeBoardDto;

import java.util.List;

public interface BoardService {

    BoardDto saveBoard(BoardDto boardDto);
    ChangeBoardDto changeBoard(Long id, String title, String contents) throws Exception;
    void deleteBoard(Long id) throws Exception;
    List<BoardListDto> listBoard();
    List<BoardListDto> listBoardByCreated();
    List<BoardListDto> listBoardByUserId(String userId);
    List<BoardListDto> listBoardById(Long id);
}
