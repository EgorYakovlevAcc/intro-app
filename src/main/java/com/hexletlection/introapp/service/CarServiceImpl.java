package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dao.CarRepository;
import com.hexletlection.introapp.dto.CarDto;
import com.hexletlection.introapp.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> saveAll(List<CarDto> carDtoList) {
        List<Car> cars = carDtoList.stream()
                .map(carDto -> {
                    Car car = new Car();
                    car.setName(carDto.getName());
                    return car;
                })
                .collect(Collectors.toList());

        return carRepository.saveAll(cars);
    }
}
