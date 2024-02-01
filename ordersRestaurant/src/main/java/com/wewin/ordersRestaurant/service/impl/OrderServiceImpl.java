package com.wewin.ordersRestaurant.service.impl;

import com.wewin.ordersRestaurant.entity.Order;
import com.wewin.ordersRestaurant.model.Sale;
import com.wewin.ordersRestaurant.repository.OrderRepository;
import com.wewin.ordersRestaurant.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders(Integer table) {
        return orderRepository.findOrdersByTableNumber(table);
    }

    @Override
    public Map<String, String> addOrder(Order order) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Order added");
        order.setTotal(order.getAmount() * order.getPrice());
        orderRepository.save(order);
        return response;
    }

    @Override
    @Transactional
    public Sale generateSale(Integer table) {
        List<Order> orders = orderRepository.findOrdersByTableNumber(table);
        Integer total = orders.stream().mapToInt(Order::getTotal).sum();
        Sale sale = new Sale(orders, total);
        orderRepository.deleteByTableNumber(table);
        return sale;
    }
}