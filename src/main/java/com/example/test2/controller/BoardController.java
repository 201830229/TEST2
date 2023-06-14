package com.example.test2.controller;

import com.example.test2.dto.BoardDto;
import com.example.test2.dto.BoardListDto;
import com.example.test2.dto.ChangeBoardDto;
import com.example.test2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PutMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<ChangeBoardDto> changeProduct(@RequestBody ChangeBoardDto changeBoardDto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.changeBoard(changeBoardDto.getId(), changeBoardDto.getTitle(), changeBoardDto.getContents()));
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.saveBoard(boardDto));
    }

    @DeleteMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<String> deleteBoard(Long id) throws Exception {
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardListDto>> listBoard() {
        List <BoardListDto> boardListDto = boardService.listBoard();
        return ResponseEntity.status(HttpStatus.OK).body(boardListDto);
    }

    @GetMapping("/listOrderByCreatedAt")
    public ResponseEntity<List<BoardListDto>> listBoardByCreated() {
        List <BoardListDto> boardListDto = boardService.listBoardByCreated();
        return ResponseEntity.status(HttpStatus.OK).body(boardListDto);
    }

    @GetMapping("/byUserId")
    public ResponseEntity<List<BoardListDto>> listBoardByUserId(String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.listBoardByUserId(userId));
    }

    @GetMapping("/")
    public ResponseEntity<List<BoardListDto>> listBoardById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.listBoardById(id));
    }
}
