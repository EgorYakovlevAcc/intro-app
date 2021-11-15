package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dto.CarDto;
import com.hexletlection.introapp.model.Car;

public interface CarService {
    void createCar(CarDto carDto, Long userId);

    Car getCarById(Long carId);
}
