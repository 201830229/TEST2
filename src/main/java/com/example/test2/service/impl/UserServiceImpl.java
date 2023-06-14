package com.example.test2.service.impl;

import com.example.test2.dao.UserDAO;
import com.example.test2.dto.UserDto;
import com.example.test2.entity.User;
import com.example.test2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<UserDto> listUser() {
        List<User> users = userDAO.listUser();
        List<UserDto> userDtoList = users.stream().map(user -> new UserDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public List<UserDto> listUserByName() {
        List<User> users = userDAO.listUserByName();
        List<UserDto> userDtoList = users.stream().map(user -> new UserDto(user)).collect(Collectors.toList());
        return userDtoList;
    }
}
