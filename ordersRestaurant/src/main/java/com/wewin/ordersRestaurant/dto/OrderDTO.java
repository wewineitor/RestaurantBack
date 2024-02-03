package com.wewin.ordersRestaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private Integer tableNumber;
    private String saucer;
    private Integer price;
    private Integer amount;
    private Integer total;
    private String comment;
}