package com.Certificados.Pablo.service;


import com.Certificados.Pablo.dto.CertificateRequest;
import com.Certificados.Pablo.entity.CertificateEntity;
import com.Certificados.Pablo.repository.CertificateRepository;

import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    private final CertificateRepository repository;
    private final BlockchainService blockchainService;

    public CertificateService(
            CertificateRepository repository,
            BlockchainService blockchainService) {

        this.repository = repository;
        this.blockchainService = blockchainService;
    }

    public String emitirCertificado(
            CertificateRequest request)
            throws Exception {

        String txHash =
                blockchainService.emitirCertificado(request);

        CertificateEntity entity =
                new CertificateEntity();

        entity.setCertificateId(
                request.getCertificateId());

        entity.setStudentName(
                request.getStudentName());

        entity.setCourseName(
                request.getCourseName());

        entity.setInstitutionName(
                request.getInstitutionName());

        entity.setCertificateHash(
                request.getCertificateHash());

        entity.setTransactionHash(txHash);

        entity.setIssueDate(
                System.currentTimeMillis());

        repository.save(entity);

        return txHash;
    }
}