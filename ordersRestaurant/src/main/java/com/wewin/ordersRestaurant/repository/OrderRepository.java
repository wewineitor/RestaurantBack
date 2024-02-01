package com.wewin.ordersRestaurant.repository;

import com.wewin.ordersRestaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByTableNumber(Integer table);
    void deleteByTableNumber(Integer table);
}