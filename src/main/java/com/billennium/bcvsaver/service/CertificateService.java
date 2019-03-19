package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.asm.CertificateAsm;
import com.billennium.bcvsaver.dto.CertificateDto;
import com.billennium.bcvsaver.entity.Certificate;
import com.billennium.bcvsaver.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CertificateService {
    private final CertificateRepository certificateRepository;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    private Certificate addCertificate(CertificateDto certificateDto) {
        return certificateRepository.save(CertificateAsm.makeCertificate(certificateDto));
    }

    List<Certificate> addCertificates(List<CertificateDto> certificateDtos) {
        return Optional.ofNullable(certificateDtos).orElse(List.of())
                .stream()
                .filter(Objects::nonNull)
                .map(this::addCertificate)
                .collect(Collectors.toList());
    }
}
