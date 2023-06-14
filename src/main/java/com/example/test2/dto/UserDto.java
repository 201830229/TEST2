package com.example.test2.dto;

import com.example.test2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private String uid;

    private String password;

    private String name;

    private String email;
    private List<String> roles = new ArrayList<>();

    public UserDto(User user) {
        this(user.getUid(), user.getPassword(), user.getName(), user.getEmail(), user.getRoles());
    }
}
