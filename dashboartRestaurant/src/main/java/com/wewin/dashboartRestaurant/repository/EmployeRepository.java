package com.wewin.dashboartRestaurant.repository;

import com.wewin.dashboartRestaurant.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    Employe findEmployeById(Long id);
    Employe findEmployeByPhone(String phone);
}
