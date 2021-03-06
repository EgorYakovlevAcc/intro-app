package com.hexletlection.introapp.config;

import com.hexletlection.introapp.dao.CarRepository;
import com.hexletlection.introapp.dao.OrderRepository;
import com.hexletlection.introapp.dao.UserRepository;
import com.hexletlection.introapp.service.*;
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

    @Bean
    public OrderService orderService(OrderRepository orderRepository, UserService userService, CarService carService) {
        return new OrderServiceImpl(orderRepository, userService, carService);
    }
}
