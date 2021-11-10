package com.hexletlection.introapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexletlection.introapp.dao.UserRepository;
import com.hexletlection.introapp.dto.CarDto;
import com.hexletlection.introapp.dto.UserDto;
import com.hexletlection.introapp.model.Car;
import com.hexletlection.introapp.model.User;
import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityManager;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntroAppApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;
    private static final String USERNAME_POSITIVE_SEARCH = "Egor_test_test";

    @BeforeAll
    public void setUp() {
        User user = new User();
        user.setUsername(USERNAME_POSITIVE_SEARCH);

        Car car = new Car();
        car.setUser(user);
        car.setName("BMW_TEST_TEST");


        user.setCars(List.of(car));

        userRepository.save(user);
    }

    @Test
    public void getUserByUsername_positive() throws Exception {
        String username = "Egor_test2";
        mockMvc.perform(MockMvcRequestBuilders.get("/v1.0/users/" + username))
                .andExpect(status().isOk());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Egor_not_existed", "Ivan_not_existed"})
    public void getUserByUsername_negative(String username) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1.0/users/" + username))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createUser_positive() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUsername("User_test");

        CarDto carDto = new CarDto();
        carDto.setName("BMW");

        userDto.setCars(List.of(carDto));

        mockMvc.perform(MockMvcRequestBuilders.post("/v1.0/users/")
                        .content(objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @ParameterizedTest
    @ValueSource(strings = {"request/less_than_3_chars_username.json", "request/null_username.json"})
    public void createUser_negative(String requestDataPath) throws Exception {
        UserDto userDto = objectMapper.readValue(resourceLoader.getResource("classpath:" + requestDataPath).getFile(), UserDto.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/v1.0/users/")
                        .content(objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @AfterAll
    public void destroy() {

    }
}
