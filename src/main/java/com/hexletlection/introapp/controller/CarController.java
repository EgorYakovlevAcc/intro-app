package com.hexletlection.introapp.controller;

import com.hexletlection.introapp.dto.CarDto;
import com.hexletlection.introapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/v1.0/cars/")
    public String createCar(@RequestBody CarDto carDto, @RequestParam("user_id") Long userId) {
        carService.createCar(carDto, userId);
        return "OK";
    }
}
