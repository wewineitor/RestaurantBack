package com.wewin.ordersRestaurant.controller;

import com.wewin.ordersRestaurant.dto.OrderDTO;
import com.wewin.ordersRestaurant.model.Sale;
import com.wewin.ordersRestaurant.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{table}")
    public ResponseEntity<List<OrderDTO>> getOrders(@PathVariable Integer table) {
        return ResponseEntity.ok(orderService.getOrders(table));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addOrder(@RequestBody OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/sale/{table}")
    public ResponseEntity<Sale> generatedSale(@PathVariable Integer table) {
        return ResponseEntity.ok(orderService.generateSale(table));
    }
}
