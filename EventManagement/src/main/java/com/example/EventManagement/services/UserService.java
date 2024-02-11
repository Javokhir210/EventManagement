package com.example.EventManagement.services;

import com.example.EventManagement.dto.EventDto;
import com.example.EventManagement.dto.UserDto;
import com.example.EventManagement.models.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    UserDto findUserById(long userId);
//    Users saveUser(UserDto userDto);

    void saveUser(UserDto userDto);
    boolean loginUser(String name, String password);
}
