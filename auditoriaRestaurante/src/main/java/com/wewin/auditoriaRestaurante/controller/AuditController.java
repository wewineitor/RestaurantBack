package com.wewin.auditoriaRestaurante.controller;

import com.wewin.auditoriaRestaurante.dto.AuditDTO;
import com.wewin.auditoriaRestaurante.entity.Audit;
import com.wewin.auditoriaRestaurante.service.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/audit")
@AllArgsConstructor
public class AuditController {
    private final AuditService auditService;

    @GetMapping
    public ResponseEntity<List<AuditDTO>> getAllAudits() {
        return ResponseEntity.ok(auditService.getAllAudits());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addAudit(@RequestBody AuditDTO auditDTO) {
        auditService.addAudit(auditDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
