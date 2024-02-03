package com.wewin.auditoriaRestaurante.service.impl;

import com.wewin.auditoriaRestaurante.dto.AuditDTO;
import com.wewin.auditoriaRestaurante.entity.Audit;
import com.wewin.auditoriaRestaurante.repository.AuditRepository;
import com.wewin.auditoriaRestaurante.service.AuditService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService {
    private final AuditRepository auditRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AuditDTO> getAllAudits() {
        List<Audit> audits = auditRepository.findAll();
        return audits.stream()
                .map(audit -> modelMapper.map(audit, AuditDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addAudit(AuditDTO auditDTO) {
        Audit audit = modelMapper.map(auditDTO, Audit.class);
        LocalDateTime date = LocalDateTime.now();
        audit.setDate(date.toLocalDate());
        auditRepository.save(audit);
    }
}
