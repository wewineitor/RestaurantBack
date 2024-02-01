package com.wewin.auditoriaRestaurante.service;

import com.wewin.auditoriaRestaurante.entity.Audit;

import java.util.List;
import java.util.Map;

public interface AuditService {
    List<Audit> getAllAudits();
    Map<String, String> addAudit(Audit audit);
}
