package com.hexletlection.introapp.dao;

import com.hexletlection.introapp.model.Car;
import com.hexletlection.introapp.model.Order;
import com.hexletlection.introapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderById(Long orderId);

    Order findOrderByCar(Car car);

    List<Order> findOrdersByCarAndUser(Car car, User user);
}
