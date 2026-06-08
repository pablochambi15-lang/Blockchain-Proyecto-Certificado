package com.Certificados.Pablo;

import com.Certificados.Pablo.dto.CertificateResponse;
import com.Certificados.Pablo.service.BlockchainService;

public class TestBlockchain {

    public static void main(String[] args) throws Exception {

        BlockchainService service =
                new BlockchainService();

        CertificateResponse response =
                service.verificarCertificado("CERT-001");

        System.out.println(response.getStudentName());
        System.out.println(response.getCourseName());
        System.out.println(response.getInstitutionName());
    }
}