package com.wewin.auditoriaRestaurante.controller;

import com.wewin.auditoriaRestaurante.entity.Audit;
import com.wewin.auditoriaRestaurante.service.AuditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/audit")
public class AuditController {
    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping
    public ResponseEntity<List<Audit>> getAllAudits() {
        return new ResponseEntity<>(auditService.getAllAudits(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addAudit(@RequestBody Audit audit) {
        return new ResponseEntity<>(auditService.addAudit(audit), HttpStatus.CREATED);
    }
}
