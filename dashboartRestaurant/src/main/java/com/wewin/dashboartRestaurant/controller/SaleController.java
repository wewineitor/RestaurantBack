package com.wewin.dashboartRestaurant.controller;

import com.wewin.dashboartRestaurant.entity.Sale;
import com.wewin.dashboartRestaurant.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/sale")
    public ResponseEntity<List<Sale>> getSales() {
        return ResponseEntity.ok(saleService.getSales());
    }

    @PostMapping("/sale")
    public ResponseEntity<HttpStatus> addSale(@RequestBody Sale sale) {
        saleService.addSale(sale);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
