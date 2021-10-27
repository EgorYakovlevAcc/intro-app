package com.hexletlection.introapp.config;

import com.hexletlection.introapp.service.UserService;
import com.hexletlection.introapp.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntroAppConfig {
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
