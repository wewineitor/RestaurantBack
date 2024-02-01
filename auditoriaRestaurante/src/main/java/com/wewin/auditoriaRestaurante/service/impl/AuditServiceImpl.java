package com.wewin.auditoriaRestaurante.service.impl;

import com.wewin.auditoriaRestaurante.entity.Audit;
import com.wewin.auditoriaRestaurante.repository.AuditRepository;
import com.wewin.auditoriaRestaurante.service.AuditService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuditServiceImpl implements AuditService {
    private final AuditRepository auditRepository;

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    @Override
    public Map<String, String> addAudit(Audit audit) {
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Audit added");
        LocalDateTime date = LocalDateTime.now();
        audit.setDate(date.toLocalDate());
        auditRepository.save(audit);
        return response;
    }
}
