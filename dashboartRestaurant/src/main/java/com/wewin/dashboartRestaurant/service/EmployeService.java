package com.wewin.dashboartRestaurant.service;

import com.wewin.dashboartRestaurant.dto.EmployeDTO;

import java.util.List;

public interface EmployeService {
    List<EmployeDTO> getAllEmployes();
    void addEmploye(EmployeDTO employe);
    void updateEmploye(Long id, EmployeDTO employe);
    void deleteEmploye(Long id);
    EmployeDTO login(String phone, String password);
}
