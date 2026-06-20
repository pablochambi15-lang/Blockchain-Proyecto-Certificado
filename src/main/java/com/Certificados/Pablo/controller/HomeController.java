package com.Certificados.Pablo.controller;


import com.Certificados.Pablo.dto.CertificateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {

        return "index";
    }

    @GetMapping("/emitir")
    public String emitirPagina(Model model) {

        model.addAttribute(
                "certificateRequest",
                new CertificateRequest());

        return "emitir";
    }

    @GetMapping("/verificar")
    public String verificarPagina() {

        return "verificar";
    }

}