package com.hexletlection.introapp.config;

import com.hexletlection.introapp.dao.CarRepository;
import com.hexletlection.introapp.dao.UserRepository;
import com.hexletlection.introapp.service.CarService;
import com.hexletlection.introapp.service.CarServiceImpl;
import com.hexletlection.introapp.service.UserService;
import com.hexletlection.introapp.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntroAppConfig {
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public CarService carService(CarRepository carRepository, UserService userService) {
        return new CarServiceImpl(carRepository, userService);
    }
}
