package com.Certificados.Pablo.dto;

import jakarta.validation.constraints.NotBlank;

public class CertificateRequest {

    @NotBlank(message = "El ID del certificado es obligatorio")
    private String certificateId;

    @NotBlank(message = "El nombre del alumno es obligatorio")
    private String studentName;

    @NotBlank(message = "El curso es obligatorio")
    private String courseName;

    @NotBlank(message = "La institución es obligatoria")
    private String institutionName;

    public String getCertificateId() {
        return certificateId;
    }
    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getInstitutionName() {
        return institutionName;
    }
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
    // getters y setters
}