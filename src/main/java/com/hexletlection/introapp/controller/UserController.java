package com.hexletlection.introapp.controller;

import com.hexletlection.introapp.dto.UserDto;
import com.hexletlection.introapp.exception.CustomException;
import com.hexletlection.introapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/v1.0")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/full/")
    public String createUserFull(@RequestBody @Valid UserDto userDto) {
        userService.createComplexUser(userDto);
        return "OK";
    }

    @PostMapping("/users/")
    public String createUser(@RequestBody @Valid UserDto userDto) {
        userService.createUser(userDto);
        return "OK";
    }

    @GetMapping("/users/{username}")
    public ResponseEntity getUserByUsername(@PathVariable("username") String username) {
        try {
            return ResponseEntity.ok(this.userService.getUserByUsername(username));
        } catch (CustomException e) {
            if (Objects.equals(e.getErrorCode(), "IA-000")) {
                return ResponseEntity.badRequest().body("");
            }
            return ResponseEntity.internalServerError().body("");
        }
    }
}
