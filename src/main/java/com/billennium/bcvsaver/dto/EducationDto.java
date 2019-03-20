package com.billennium.bcvsaver.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class EducationDto {
    private String name;
    private Date dateFrom;
    private Date dateTo;
}
