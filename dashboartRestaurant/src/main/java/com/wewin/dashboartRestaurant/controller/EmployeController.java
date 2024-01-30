package com.wewin.dashboartRestaurant.controller;

import com.wewin.dashboartRestaurant.entity.Employe;
import com.wewin.dashboartRestaurant.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employe")
public class EmployeController {
    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public ResponseEntity<List<Employe>> getEmployes() {
        return new ResponseEntity<>(employeService.getAllEmployes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addEmploye(@RequestBody Employe employe) {
        return new ResponseEntity<>(employeService.addEmploye(employe), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Employe>> login(@RequestBody Employe employe) {
        return new ResponseEntity<>(employeService.login(employe.getPhone(), employe.getPassword()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        return new ResponseEntity<>(employeService.updateEmploye(id, employe), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteEmploye(@PathVariable Long id) {
        return new ResponseEntity<>(employeService.deleteEmploye(id), HttpStatus.OK);
    }
}
