package com.hexletlection.introapp.controller;

import com.hexletlection.introapp.dto.UserDto;
import com.hexletlection.introapp.service.UserService;
import com.hexletlection.introapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/")
    public String createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return "OK";
    }
}
