package com.Certificados.Pablo.dto;

public class CertificateResponse {

    private String studentName;
    private String courseName;
    private String institutionName;
    private Long issueDate;
    private String certificateHash;
    private String issuedBy;
    
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
    public Long getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Long issueDate) {
        this.issueDate = issueDate;
    }
    public String getCertificateHash() {
        return certificateHash;
    }
    public void setCertificateHash(String certificateHash) {
        this.certificateHash = certificateHash;
    }
    public String getIssuedBy() {
        return issuedBy;
    }
    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    // getters y setters
}