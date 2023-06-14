package com.example.test2.service;

import com.example.test2.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> listUser();
    List<UserDto> listUserByName();
}
