package com.wewin.dashboartRestaurant.service.impl;

import com.wewin.dashboartRestaurant.entity.Employe;
import com.wewin.dashboartRestaurant.repository.EmployeRepository;
import com.wewin.dashboartRestaurant.service.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService {
    private final EmployeRepository employeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private void encodeAndSaveEmploye(Employe employe) {
        String encodedPassword = passwordEncoder.encode(employe.getPassword());
        employe.setPassword(encodedPassword);
        employeRepository.save(employe);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Map<String, String> addEmploye(Employe employe) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Employe added");
        encodeAndSaveEmploye(employe);
        return response;
    }

    @Override
    public Map<String, String> updateEmploye(Long id, Employe employe) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Employe update");
        Employe existingEmploye = employeRepository.findEmployeById(id);
        existingEmploye.setName(employe.getName());
        existingEmploye.setLastname(employe.getLastname());
        existingEmploye.setRol(employe.getRol());
        existingEmploye.setPassword(employe.getPassword());
        existingEmploye.setPhone(employe.getPhone());
        encodeAndSaveEmploye(existingEmploye);
        return response;
    }

    @Override
    public Map<String, String> deleteEmploye(Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Employe remove");
        employeRepository.deleteById(id);
        return response;
    }

    @Override
    public Map<String, Employe> login(String phone, String password) {
        Employe employe = employeRepository.findEmployeByPhone(phone);
        Map<String, Employe> response = new HashMap<>();
        if (employe != null && passwordEncoder.matches(password, employe.getPassword())) {
            response.put("User", employe);
            return response;
        }
        return null;
    }
}
