package com.wewin.auditoriaRestaurante.service;

import com.wewin.auditoriaRestaurante.dto.AuditDTO;

import java.util.List;

public interface AuditService {
    List<AuditDTO> getAllAudits();
    void addAudit(AuditDTO auditDTO);
}
