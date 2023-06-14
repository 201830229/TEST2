package com.example.test2.repository;

import com.example.test2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUid(String uid);

    List<User> findAllByOrderByIdAsc();
    List<User> findAllByOrderByNameAsc();
}