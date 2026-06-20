package com.Certificados.Pablo.service;


import com.Certificados.Pablo.dto.CertificateRequest;
import com.Certificados.Pablo.entity.CertificateEntity;
import com.Certificados.Pablo.repository.CertificateRepository;
import com.Certificados.Pablo.util.HashUtil;
import com.Certificados.Pablo.pdf.PdfService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CertificateService {

        private final PdfService pdfService;
    private final CertificateRepository repository;
    private final BlockchainService blockchainService;

    public CertificateService(
        CertificateRepository repository,
        BlockchainService blockchainService,
        PdfService pdfService) {

    this.repository = repository;
    this.blockchainService = blockchainService;
    this.pdfService = pdfService;
}

    public String emitirCertificado(
        CertificateRequest request)
        throws Exception {

    if (repository.findByCertificateId(
            request.getCertificateId()).isPresent()) {

        throw new RuntimeException(
                "El certificado ya existe");
    }

    String datos =

        request.getCertificateId()
      + request.getStudentName()
      + request.getCourseName()
      + request.getInstitutionName();

        String certificateHash =
        HashUtil.generarHash(datos);

        String txHash =
        blockchainService.emitirCertificado(
                request,
                certificateHash);

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
        certificateHash);

    entity.setTransactionHash(txHash);

    entity.setIssueDate(
            System.currentTimeMillis());

    repository.save(entity);
    pdfService.generarPdf(entity);

    return txHash;
}

    public List<CertificateEntity> obtenerTodos() {

    return repository.findAll();
}

}
