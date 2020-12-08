package ru.sbt.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sbt.spring.DAO.AuditRepository;
import ru.sbt.spring.DAO.entity.Audit;

import java.util.List;

@Controller
public class AuditController {
    private final AuditRepository auditRepository;

    AuditController(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @GetMapping("/audit")
    String showAuditPage(ModelMap model) {
        List<Audit> auditList = auditRepository.findAll();
        model.put("audit", auditList);
        return "audit";
    }
}
