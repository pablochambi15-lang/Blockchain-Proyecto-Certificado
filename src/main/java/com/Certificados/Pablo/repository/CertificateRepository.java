package com.Certificados.Pablo.repository;



import com.Certificados.Pablo.entity.CertificateEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository
        extends JpaRepository<CertificateEntity, Long> {
        Optional<CertificateEntity> findByCertificateId(
        String certificateId);
        List<CertificateEntity> findAll();
        

}