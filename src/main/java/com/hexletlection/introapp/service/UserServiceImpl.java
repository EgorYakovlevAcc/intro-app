package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void createUser(UserDto userDto) {
        LOGGER.info("User has been created successfully");
    }
}
