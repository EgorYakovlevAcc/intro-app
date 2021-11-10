package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dto.CarDto;

public interface CarService {
    void createCar(CarDto carDto, Long userId);
}
