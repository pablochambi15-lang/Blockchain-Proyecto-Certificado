package com.Certificados.Pablo.controller;


import com.Certificados.Pablo.dto.CertificateRequest;
import com.Certificados.Pablo.dto.CertificateResponse;
import com.Certificados.Pablo.service.BlockchainService;
import com.Certificados.Pablo.service.CertificateService;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

        

    private final BlockchainService blockchainService;

    @PostMapping("/emitir")
public String emitirCertificado(
        @Valid CertificateRequest request,
        BindingResult result,
        Model model)
        throws Exception {
                    if (result.hasErrors()) {

        return "emitir";
    }


    String txHash =
            certificateService
                    .emitirCertificado(request);

    model.addAttribute(
            "txHash",
            txHash);

    return "resultado";
}
@PostMapping("/verificar")
public String verificarCertificado(

        @RequestParam String certificateId,

        Model model)

        throws Exception {

    CertificateResponse response =

            blockchainService
                    .verificarCertificado(
                            certificateId);

    model.addAttribute(
            "certificado",
            response);

    return "resultadoVerificacion";
}

    private final CertificateService certificateService;

    public ViewController(
 
        CertificateService certificateService,

        BlockchainService blockchainService) {

    this.certificateService = certificateService;

    this.blockchainService = blockchainService;
}

}