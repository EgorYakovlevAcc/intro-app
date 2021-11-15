package com.hexletlection.introapp.service;

public interface OrderService {
    void createOrder(Long userId);

    void handleCarInProd(Long orderId, Long carId);

    void handleCarProdCompleted(Long carId);

    void handleCarDelivered(Long carId);

    void handleFinish(Long carId);
}
