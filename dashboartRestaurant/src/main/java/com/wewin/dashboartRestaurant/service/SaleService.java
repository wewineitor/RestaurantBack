package com.wewin.dashboartRestaurant.service;

import com.wewin.dashboartRestaurant.entity.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> getSales();
    void addSale(Sale sale);
}
