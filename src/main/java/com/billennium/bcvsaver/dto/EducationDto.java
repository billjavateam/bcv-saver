package com.billennium.bcvsaver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EducationDto {
    private String name;
    private Date from;
    private Date to;
}
