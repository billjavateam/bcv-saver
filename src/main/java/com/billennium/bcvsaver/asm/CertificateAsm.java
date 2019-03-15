package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.CertificateDto;
import com.billennium.bcvsaver.entity.Certificate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CertificateAsm {
    public static Certificate makeCertificate(CertificateDto certificateDto) {
        return Certificate.builder()
                .date(certificateDto.getDate())
                .name(certificateDto.getName())
                .build();
    }

    public static List<Certificate> makeCertificates(List<CertificateDto> certificates) {
       /* return certificates.stream()
                .filter(Objects::nonNull)
                .map(certificate -> Certificate.builder()
                        .date(certificate.getDate())
                        .name(certificate.getName())
                        .build()).collect(Collectors.toList());*/
       return Optional.ofNullable(certificates).orElse(List.of())
               .stream()
               .filter(Objects::nonNull)
               .map(certificate -> Certificate.builder()
                       .date(certificate.getDate())
                       .name(certificate.getName())
                       .build()).collect(Collectors.toList());
    }
}
