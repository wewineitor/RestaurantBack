package com.wewin.dashboartRestaurant.service;

import com.wewin.dashboartRestaurant.dto.SaleDTO;

import java.util.List;

public interface SaleService {
    List<SaleDTO> getSales();
    void addSale(SaleDTO saleDTO);
}
