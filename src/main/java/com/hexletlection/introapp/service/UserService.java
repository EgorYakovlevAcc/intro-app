package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dto.UserDto;
import com.hexletlection.introapp.exception.CustomException;

import java.util.List;

public interface UserService {
    void createUser(UserDto userDto);
    List<UserDto> getUserByUsername(String username) throws CustomException;
}
