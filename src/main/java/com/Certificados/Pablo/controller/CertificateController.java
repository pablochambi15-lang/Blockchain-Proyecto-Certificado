package com.Certificados.Pablo.controller;



import com.Certificados.Pablo.dto.CertificateRequest;
import com.Certificados.Pablo.dto.CertificateResponse;
import com.Certificados.Pablo.entity.CertificateEntity;
import com.Certificados.Pablo.service.CertificateService;
import com.Certificados.Pablo.service.BlockchainService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificados")
public class CertificateController {

    private final CertificateService certificateService;
    private final BlockchainService blockchainService;

    public CertificateController(
            CertificateService certificateService,
            BlockchainService blockchainService) {

        this.certificateService = certificateService;
        this.blockchainService = blockchainService;
    }

    @PostMapping
    public String emitirCertificado(
            @RequestBody CertificateRequest request)
            throws Exception {

        return certificateService.emitirCertificado(request);
    }

    @GetMapping("/{id}")
    public CertificateResponse verificarCertificado(
            @PathVariable String id)
            throws Exception {

        return blockchainService.verificarCertificado(id);
    }
    @GetMapping
    public List<CertificateEntity> obtenerTodos() {

    return certificateService.obtenerTodos();
}
}