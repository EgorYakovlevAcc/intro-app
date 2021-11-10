package com.hexletlection.introapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "boxes")
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Car> cars;
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
