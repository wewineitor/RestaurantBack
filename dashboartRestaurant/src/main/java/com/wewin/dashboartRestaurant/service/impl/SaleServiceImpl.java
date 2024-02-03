package com.wewin.dashboartRestaurant.service.impl;

import com.wewin.dashboartRestaurant.dto.SaleDTO;
import com.wewin.dashboartRestaurant.entity.Sale;
import com.wewin.dashboartRestaurant.repository.SaleRepository;
import com.wewin.dashboartRestaurant.service.SaleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<SaleDTO> getSales() {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream()
                .map(sale -> modelMapper.map(sale, SaleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addSale(SaleDTO saleDTO) {
        Sale sale = modelMapper.map(saleDTO, Sale.class);
        LocalDateTime date = LocalDateTime.now();
        sale.setDate(date.toLocalDate());
        saleRepository.save(sale);
    }
}
