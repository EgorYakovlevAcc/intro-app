package com.hexletlection.introapp.dto;

import java.util.List;

public class UserDto {
    private String username;
    private List<CarDto> cars;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }
}
