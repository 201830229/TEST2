package com.example.test2.repository;

import com.example.test2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByOrderByCreatedAtDesc();
    List<Board> findByUserId(String userId);
}
