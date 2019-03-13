package com.billennium.bcvsaver.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data public class CertificateDto {
    private String name;
    private Date date;
}
