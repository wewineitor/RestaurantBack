package com.wewin.dashboartRestaurant.service;

import com.wewin.dashboartRestaurant.entity.Employe;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeService {
    List<Employe> getAllEmployes();
    Map<String, String> addEmploye(Employe employe);
    Map<String, String> updateEmploye(Long id, Employe employe);
    Map<String, String> deleteEmploye(Long id);
    Map<String, Employe> login(String phone, String password);
}
