package com.hexletlection.introapp.service;

import com.hexletlection.introapp.IntroAppConstants;
import com.hexletlection.introapp.dao.UserRepository;
import com.hexletlection.introapp.dto.CarDto;
import com.hexletlection.introapp.dto.UserDto;
import com.hexletlection.introapp.exception.CustomException;
import com.hexletlection.introapp.model.Box;
import com.hexletlection.introapp.model.Car;
import com.hexletlection.introapp.model.Document;
import com.hexletlection.introapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createComplexUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());

        user.setCars(userDto.getCars().stream()
                .map(carDto -> {
                    Car car = new Car();
                    car.setName(carDto.getName());
                    car.setUser(user);

                    Document document = new Document();
                    document.setSerialNumber(carDto.getDocument().getSerialNumber());
                    document.setCar(car);
                    car.setDocument(document);

                    car.setBoxes(carDto.getBoxes().stream()
                            .map(boxDto -> {
                                Box box = new Box();
                                box.setNumber(boxDto.getNumber());
                                box.setCars(List.of(car));
                                return box;
                            })
                            .collect(Collectors.toList()));
                    return car;
                })
                .collect(Collectors.toList()));

        userRepository.save(user);
        LOGGER.info("User {} has been saved successfully", user.getUsername());
    }

    @Override
    public List<UserDto> getUserByUsername(String username) throws CustomException {
        List<User> users = userRepository.findUsersByUsername(username);
        if (!CollectionUtils.isEmpty(users)) {
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
        throw IntroAppConstants.USER_NOT_FOUND_EXCEPTION;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());

        userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }
}
