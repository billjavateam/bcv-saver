package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.CertificateDto;
import com.billennium.bcvsaver.entity.Certificate;

public class CertificateAsm {
    public static Certificate makeCertificate(CertificateDto certificateDto) {
        return Certificate.builder()
                .date(certificateDto.getDate())
                .name(certificateDto.getName())
                .build();
    }
}
