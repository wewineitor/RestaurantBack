package com.wewin.ordersRestaurant.model;

import com.wewin.ordersRestaurant.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sale {
    private List<Order> orders;
    private Integer total;
}
