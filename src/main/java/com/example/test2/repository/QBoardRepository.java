package com.example.test2.repository;

import com.example.test2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QBoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
}
