package com.wewin.ordersRestaurant.controller;

import com.wewin.ordersRestaurant.entity.Order;
import com.wewin.ordersRestaurant.model.Sale;
import com.wewin.ordersRestaurant.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{table}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable Integer table) {
        return new ResponseEntity<>(orderService.getOrders(table), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/sale/{table}")
    public ResponseEntity<Sale> generatedSale(@PathVariable Integer table) {
        return new ResponseEntity<>(orderService.generateSale(table), HttpStatus.OK);
    }
}
