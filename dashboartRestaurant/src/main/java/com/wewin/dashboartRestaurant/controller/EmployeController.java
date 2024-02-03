package com.wewin.dashboartRestaurant.controller;

import com.wewin.dashboartRestaurant.dto.EmployeDTO;
import com.wewin.dashboartRestaurant.service.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@AllArgsConstructor
public class EmployeController {
    private final EmployeService employeService;

    @GetMapping("/employe")
    public ResponseEntity<List<EmployeDTO>> getEmployes() {
        return ResponseEntity.ok(employeService.getAllEmployes());
    }

    @PostMapping("/employe")
    public ResponseEntity<HttpStatus> addEmploye(@RequestBody EmployeDTO employeDTO) {
        employeService.addEmploye(employeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<EmployeDTO> login(@RequestBody EmployeDTO employeDTO) {
        return  ResponseEntity.ok(employeService.login(employeDTO.getPhone(), employeDTO.getPassword()));
    }

    @PutMapping("/employe/{id}")
    public ResponseEntity<HttpStatus> updateEmploye(@PathVariable Long id, @RequestBody EmployeDTO employeDTO) {
        employeService.updateEmploye(id, employeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/employe/{id}")
    public ResponseEntity<HttpStatus> deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmploye(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
