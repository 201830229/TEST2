package com.example.test2.dao;

import com.example.test2.entity.Board;
import com.example.test2.entity.Product;

import java.util.List;
import java.util.Optional;

public interface BoardDAO {
    Board insertBoard(Board board);
    Board changeBoard(Long id ,String title, String contents) throws Exception;
    Board selectBoard(Long id);
    void deleteBoard(Long id) throws Exception;
    List<Board> listBoard();
    List<Board> listBoardByCreated();
    List<Board> listBoardByUserId(String userId);
    Optional<Board> listBoardById(Long id);
}
