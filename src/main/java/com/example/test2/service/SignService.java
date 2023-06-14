package com.example.test2.service;

import com.example.test2.dto.SignInResultDto;
import com.example.test2.dto.SignUpResultDto;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String email, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;

}