package com.wewin.dashboartRestaurant.controller;

import com.wewin.dashboartRestaurant.dto.SaleDTO;
import com.wewin.dashboartRestaurant.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@AllArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @GetMapping("/sale")
    public ResponseEntity<List<SaleDTO>> getSales() {
        return ResponseEntity.ok(saleService.getSales());
    }

    @PostMapping("/sale")
    public ResponseEntity<HttpStatus> addSale(@RequestBody SaleDTO saleDTO) {
        saleService.addSale(saleDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
