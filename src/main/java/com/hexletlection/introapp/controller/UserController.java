package com.hexletlection.introapp.controller;

import com.hexletlection.introapp.dto.UserDto;
import com.hexletlection.introapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/users/{username}")
    public List<UserDto> createUser(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }
}
