package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.dto.CertificateDto;
import com.billennium.bcvsaver.entity.Certificate;

import java.util.List;

public interface CertificateService {
    List<Certificate> addCertificates(List<CertificateDto> certificateDtos);
}
