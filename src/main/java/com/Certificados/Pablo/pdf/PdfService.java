

package com.Certificados.Pablo.pdf;

import java.io.File;

import org.springframework.stereotype.Service;

import com.Certificados.Pablo.entity.CertificateEntity;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@Service
public class PdfService {

    public void generarPdf(
            CertificateEntity certificate)
            throws Exception {

        String ruta = "certificados/"
                + certificate.getCertificateId()
                + ".pdf";

        File carpeta = new File("certificados");

        if (!carpeta.exists()) {

            carpeta.mkdirs();
        }

        PdfWriter writer =
                new PdfWriter(ruta);

        PdfDocument pdf =
                new PdfDocument(writer);

        Document document =
                new Document(pdf);

        document.add(
                new Paragraph(
                        "CERTIFICADO DE FINALIZACION"));

        document.add(
                new Paragraph(
                        "Alumno: "
                                + certificate.getStudentName()));

        document.add(
                new Paragraph(
                        "Curso: "
                                + certificate.getCourseName()));

        document.add(
                new Paragraph(
                        "Institucion: "
                                + certificate.getInstitutionName()));

        document.add(
                new Paragraph(
                        "ID: "
                                + certificate.getCertificateId()));

        document.add(
                new Paragraph(
                        "Hash: "
                                + certificate.getCertificateHash()));

        document.close();
    }
}