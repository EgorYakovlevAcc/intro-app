package com.hexletlection.introapp.dao;

import com.hexletlection.introapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findCarById(Long id);
}
