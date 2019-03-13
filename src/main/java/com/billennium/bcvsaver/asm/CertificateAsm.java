package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.CertificateDto;
import com.billennium.bcvsaver.entity.Certificate;

import java.util.List;
import java.util.stream.Collectors;

public class CertificateAsm {
    public static List<Certificate> makeCertificates(List<CertificateDto> certificates) {
        return certificates.stream()
                .map(certificate -> Certificate.builder()
                        .date(certificate.getDate())
                        .name(certificate.getName())
                        .build()).collect(Collectors.toList());
    }
}
