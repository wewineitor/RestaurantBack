package com.wewin.dashboartRestaurant.service.impl;

import com.wewin.dashboartRestaurant.entity.Sale;
import com.wewin.dashboartRestaurant.repository.SaleRepository;
import com.wewin.dashboartRestaurant.service.SaleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> getSales() {
        return saleRepository.findAll();
    }

    @Override
    public void addSale(Sale sale) {
        LocalDateTime date = LocalDateTime.now();
        sale.setDate(date.toLocalDate());
        saleRepository.save(sale);
    }
}
