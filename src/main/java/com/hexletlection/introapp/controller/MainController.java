package com.hexletlection.introapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String getIndex() {
        return "Hello, world";
    }
}
