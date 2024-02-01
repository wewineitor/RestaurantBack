package com.wewin.ordersRestaurant.service;

import com.wewin.ordersRestaurant.entity.Order;
import com.wewin.ordersRestaurant.model.Sale;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getOrders(Integer table);
    Map<String, String> addOrder(Order order);
    Sale generateSale(Integer table);
}
