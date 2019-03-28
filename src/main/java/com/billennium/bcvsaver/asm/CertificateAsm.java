package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.CertificateDto;
import com.billennium.bcvsaver.entity.Certificate;

import java.util.List;
import java.util.stream.Collectors;

public class CertificateAsm {
    public static Certificate makeCertificate(CertificateDto certificateDto) {
        return Certificate.builder()
                .date(certificateDto.getDate())
                .name(certificateDto.getName())
                .build();
    }

    public static List<Certificate> makeCertificates(List<CertificateDto> certificates) {
        return certificates.stream()
                .map(CertificateAsm::makeCertificate)
                .collect(Collectors.toList());
    }
}
