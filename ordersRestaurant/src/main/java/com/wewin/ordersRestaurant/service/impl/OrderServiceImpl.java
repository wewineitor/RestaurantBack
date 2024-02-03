package com.wewin.ordersRestaurant.service.impl;

import com.wewin.ordersRestaurant.dto.OrderDTO;
import com.wewin.ordersRestaurant.entity.Order;
import com.wewin.ordersRestaurant.model.Sale;
import com.wewin.ordersRestaurant.repository.OrderRepository;
import com.wewin.ordersRestaurant.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<OrderDTO> getOrders(Integer table) {
        List<Order> orders = orderRepository.findOrdersByTableNumber(table);
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        order.setTotal(order.getAmount() * order.getPrice());
        modelMapper.map(orderRepository.save(order), OrderDTO.class);
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