package com.example.test2.controller;

import com.example.test2.dto.UserDto;
import com.example.test2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserDto>> listUser(){
        List<UserDto> userDto = userService.listUser();
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @GetMapping("/listOrderByName")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserDto>> listUserByName(){
        List<UserDto> userDto = userService.listUserByName();
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

}
