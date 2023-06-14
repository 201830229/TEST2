package com.example.test2.dao.impl;


import com.example.test2.dao.BoardDAO;
import com.example.test2.entity.Board;
import com.example.test2.repository.BoardRepository;
import com.example.test2.repository.QBoardRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.test2.entity.QBoard.board;

@Component
public class BoardDAOImpl implements BoardDAO {

    private final BoardRepository boardRepository;
    private final QBoardRepository qBoardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository, QBoardRepository qBoardRepository){
        this.boardRepository = boardRepository;
        this.qBoardRepository = qBoardRepository;
    }

    @Override
    public Board selectBoard(Long id) {
        Predicate predicate = board.id.eq(id);
        Optional<Board> selectBoard = qBoardRepository.findOne(predicate);
        return selectBoard.isPresent() ? selectBoard.get() : null;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        Optional<Board> selectProduct = boardRepository.findById(id);
        if(selectProduct.isPresent()) {
            Board product = selectProduct.get();
            boardRepository.delete(product);
        } else {
            throw new Exception();
        }
    }

    @Override
    public List<Board> listBoard() {
        return boardRepository.findAll();
    }

    @Override
    public List<Board> listBoardByCreated() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Board> listBoardByUserId(String userId) {
        return boardRepository.findByUserId(userId);
    }

    @Override
    public Optional<Board> listBoardById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public Board insertBoard(Board board) {
        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }

    @Override
    public Board changeBoard(Long id, String title, String contents) throws Exception {
        Optional<Board> selectBoard = boardRepository.findById(id);
        Board changeBoard;
        if(selectBoard.isPresent()){
            Board board = selectBoard.get();
            board.setTitle(title);
            board.setContents(contents);
            board.setUpdatedAt(LocalDateTime.now());
            changeBoard = boardRepository.save(board);
        } else {
            throw new Exception();
        }
        return changeBoard;
    }
}
