package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dao.UserRepository;
import com.hexletlection.introapp.dto.CarDto;
import com.hexletlection.introapp.dto.UserDto;
import com.hexletlection.introapp.model.Car;
import com.hexletlection.introapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    private CarService carService;

    public UserServiceImpl(UserRepository userRepository, CarService carService) {
        this.userRepository = userRepository;
        this.carService = carService;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());

        user.setCars(userDto.getCars().stream()
                .map(carDto -> {
                    Car car = new Car();
                    car.setName(carDto.getName());
                    car.setUser(user);
                    return car;
                })
                .collect(Collectors.toList()));

        userRepository.save(user);
        LOGGER.info("User {} has been saved successfully", user.getUsername());
    }

    @Override
    public List<UserDto> getUserByUsername(String username) {
        List<User> users = userRepository.findUsersByUsername(username);
        return users.stream()
                .map(user -> {
                    UserDto userDto = new UserDto();
                    userDto.setUsername(user.getUsername());
                    userDto.setCars(user.getCars().stream()
                            .map(car -> {
                                CarDto carDto = new CarDto();
                                carDto.setName(car.getName());
                                return carDto;
                            })
                            .collect(Collectors.toList()));
                    return userDto;
                })
                .collect(Collectors.toList());
    }
}
