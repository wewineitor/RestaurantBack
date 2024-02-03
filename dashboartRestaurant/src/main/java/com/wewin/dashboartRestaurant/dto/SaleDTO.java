package com.wewin.dashboartRestaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    private Long id;
    private Integer total;
    private LocalDate date;
}