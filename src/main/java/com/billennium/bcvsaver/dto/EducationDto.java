package com.billennium.bcvsaver.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class EducationDto {
    private String name;
    private Date from;
    private Date to;
}
