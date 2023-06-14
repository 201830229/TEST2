package com.example.test2.dao;

import com.example.test2.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> listUser();
    List<User> listUserByName();
}
