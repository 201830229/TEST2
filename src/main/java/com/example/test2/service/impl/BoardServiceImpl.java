package com.example.test2.service.impl;

import com.example.test2.dao.BoardDAO;
import com.example.test2.dto.BoardDto;
import com.example.test2.dto.BoardListDto;
import com.example.test2.dto.ChangeBoardDto;
import com.example.test2.dto.ProductDto;
import com.example.test2.entity.Board;
import com.example.test2.entity.Product;
import com.example.test2.service.BoardService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public BoardDto saveBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setUserId(boardDto.getUserId());
        board.setUserName(boardDto.getUserName());
        board.setTitle(boardDto.getTitle());
        board.setContents(boardDto.getContents());
        board.setCreatedAt(LocalDateTime.now());
        board.setUpdatedAt(LocalDateTime.now());

        Board saveBoard = boardDAO.insertBoard(board);

        boardDto.setUserId(saveBoard.getUserId());
        boardDto.setUserName(saveBoard.getUserName());
        boardDto.setTitle(saveBoard.getTitle());
        boardDto.setContents(saveBoard.getContents());
        return boardDto;
    }

    @Override
    public ChangeBoardDto changeBoard(Long id, String title, String contents) throws Exception {
        Board changeBoard = boardDAO.changeBoard(id, title, contents);

        ChangeBoardDto changeBoardDto = new ChangeBoardDto();
        changeBoardDto.setId(changeBoard.getId());
        changeBoardDto.setTitle(changeBoard.getTitle());
        changeBoardDto.setContents(changeBoard.getContents());

        return changeBoardDto;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        boardDAO.deleteBoard(id);
    }

    @Override
    public List<BoardListDto> listBoard() {
        List<Board> boards = boardDAO.listBoard();
        List<BoardListDto> boardListDtoList = boards.stream().map(board -> new BoardListDto(board)).collect(Collectors.toList());
        return boardListDtoList;
    }

    @Override
    public List<BoardListDto> listBoardByCreated() {
        List<Board> boards = boardDAO.listBoardByCreated();
        List<BoardListDto> boardListDtoList = boards.stream().map(board -> new BoardListDto(board)).collect(Collectors.toList());
        return boardListDtoList;
    }

    @Override
    public List<BoardListDto> listBoardByUserId(String userId) {
        List<Board> boards = boardDAO.listBoardByUserId(userId);
        List<BoardListDto> boardListDtoList = boards.stream().map(board -> new BoardListDto(board)).collect(Collectors.toList());
        return boardListDtoList;
    }

    @Override
    public List<BoardListDto> listBoardById(Long id) {
        Optional<Board> boards = boardDAO.listBoardById(id);
        List<BoardListDto> boardListDtoList = boards.stream().map(board -> new BoardListDto(board)).collect(Collectors.toList());
        return boardListDtoList;
    }
}
