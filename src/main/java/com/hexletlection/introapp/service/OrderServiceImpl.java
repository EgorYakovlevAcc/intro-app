package com.hexletlection.introapp.service;

import com.hexletlection.introapp.dao.OrderRepository;
import com.hexletlection.introapp.model.Car;
import com.hexletlection.introapp.model.Order;
import com.hexletlection.introapp.model.Status;
import com.hexletlection.introapp.model.User;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private UserService userService;
    private CarService carService;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, CarService carService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.carService = carService;
    }

    @Override
    public void createOrder(Long userId) {
        Order order = new Order();

        User user = userService.getUserById(userId);
        order.setUser(user);
        order.setStatus(Status.START);
        orderRepository.save(order);
    }

    @Override
    public void handleCarInProd(Long orderId, Long carId) {
        Order order = orderRepository.findOrderById(orderId);
        Car car = carService.getCarById(carId);

        order.setCar(car);
        order.setStatus(Status.CAR_IN_PROD);

        orderRepository.save(order);
    }

    @Override
    public void handleCarProdCompleted(Long carId) {
        Car car = carService.getCarById(carId);
        Order order = orderRepository.findOrderByCar(car);

        order.setStatus(Status.CAR_PROD_COMPLETED);

        orderRepository.save(order);
    }

    @Override
    public void handleCarDelivered(Long carId) {
        Car car = carService.getCarById(carId);
        Order order = orderRepository.findOrderByCar(car);

        order.setStatus(Status.CAR_DELIVERED);

        orderRepository.save(order);
    }

    @Override
    public void handleFinish(Long carId) {
        Car car = carService.getCarById(carId);
        Order order = orderRepository.findOrderByCar(car);

        order.setStatus(Status.FINISH);

        orderRepository.save(order);
    }
}
