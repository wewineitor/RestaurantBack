package com.wewin.dashboartRestaurant.service.impl;

import com.wewin.dashboartRestaurant.dto.EmployeDTO;
import com.wewin.dashboartRestaurant.entity.Employe;
import com.wewin.dashboartRestaurant.repository.EmployeRepository;
import com.wewin.dashboartRestaurant.service.EmployeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService {
    private final EmployeRepository employeRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    private void encodeAndSaveEmploye(Employe employe) {
        String encodedPassword = passwordEncoder.encode(employe.getPassword());
        employe.setPassword(encodedPassword);
        employeRepository.save(employe);
    }

    @Override
    public List<EmployeDTO> getAllEmployes() {
        List<Employe> employes = employeRepository.findAll();
        return employes.stream()
                .map(employe -> modelMapper.map(employe, EmployeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addEmploye(EmployeDTO employeDTO) {
        Employe employe = modelMapper.map(employeDTO, Employe.class);
        encodeAndSaveEmploye(employe);
    }

    public void updateEmploye(Long id, EmployeDTO employeDTO) {
        Employe existingEmploye = employeRepository.findEmployeById(id);
        if (existingEmploye != null) {
            existingEmploye.setName(employeDTO.getName());
            existingEmploye.setLastname(employeDTO.getLastname());
            existingEmploye.setRol(employeDTO.getRol());
            existingEmploye.setPhone(employeDTO.getPhone());
            if (employeDTO.getPassword() != null && !employeDTO.getPassword().isEmpty()) {
                String encodedPassword = passwordEncoder.encode(employeDTO.getPassword());
                existingEmploye.setPassword(encodedPassword);
            }
            employeRepository.save(existingEmploye);
        }
    }


    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public EmployeDTO login(String phone, String password) {
        Employe employe = employeRepository.findEmployeByPhone(phone);
        if (employe != null && passwordEncoder.matches(password, employe.getPassword())) {
            return modelMapper.map(employe, EmployeDTO.class);
        }
        return null;
    }
}
