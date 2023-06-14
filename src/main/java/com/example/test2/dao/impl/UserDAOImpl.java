package com.example.test2.dao.impl;

import com.example.test2.dao.UserDAO;
import com.example.test2.entity.User;
import com.example.test2.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public UserDAOImpl(UserRepository userRepository, JPAQueryFactory jpaQueryFactory) {
        this.userRepository = userRepository;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<User> listUserByName() {
        return userRepository.findAllByOrderByNameAsc();
    }
}
