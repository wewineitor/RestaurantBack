package com.wewin.auditoriaRestaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditDTO {
    private Long id;
    private String employe;
    private String action;
    private LocalDate date;
}
