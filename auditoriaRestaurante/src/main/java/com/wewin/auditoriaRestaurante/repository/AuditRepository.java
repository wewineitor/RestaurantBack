package com.wewin.auditoriaRestaurante.repository;

import com.wewin.auditoriaRestaurante.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}
