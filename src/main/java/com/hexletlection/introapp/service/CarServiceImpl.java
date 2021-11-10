package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dao.CarRepository;
import com.hexletlection.introapp.dto.CarDto;
import com.hexletlection.introapp.model.Car;
import com.hexletlection.introapp.model.User;

public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private UserService userService;

    public CarServiceImpl(CarRepository carRepository, UserService userService) {
        this.carRepository = carRepository;
        this.userService = userService;
    }

    @Override
    public void createCar(CarDto carDto, Long userId) {
        Car car = new Car();
        car.setName(carDto.getName());

        User user = userService.getUserById(userId);

        car.setUser(user);

        carRepository.save(car);
    }
}
