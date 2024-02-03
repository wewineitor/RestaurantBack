package com.wewin.ordersRestaurant.service;

import com.wewin.ordersRestaurant.dto.OrderDTO;
import com.wewin.ordersRestaurant.model.Sale;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrders(Integer table);
    void addOrder(OrderDTO orderDTO);
    Sale generateSale(Integer table);
}
