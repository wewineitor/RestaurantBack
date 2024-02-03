package com.wewin.dashboartRestaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDTO {
    private Long id;
    private String name;
    private String lastname;
    private String password;
    private String rol;
    private String phone;
}