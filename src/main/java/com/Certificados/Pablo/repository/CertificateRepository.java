package com.Certificados.Pablo.repository;



import com.Certificados.Pablo.entity.CertificateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository
        extends JpaRepository<CertificateEntity, Long> {

}