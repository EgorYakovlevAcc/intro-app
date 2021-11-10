package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dto.UserDto;
import com.hexletlection.introapp.exception.CustomException;
import com.hexletlection.introapp.model.User;

import java.util.List;

public interface UserService {
    void createComplexUser(UserDto userDto);
    List<UserDto> getUserByUsername(String username) throws CustomException;
    void createUser(UserDto userDto);

    User getUserById(Long userId);
}
