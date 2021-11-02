package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dto.CarDto;
import com.hexletlection.introapp.model.Car;

import java.util.List;

public interface CarService {
    void save(Car car);

    List<Car> saveAll(List<CarDto> carDtoList);
}
