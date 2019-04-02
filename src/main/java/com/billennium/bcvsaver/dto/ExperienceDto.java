package com.billennium.bcvsaver.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ExperienceDto {
    private Date dateFrom;
    private Date dateTo;
    private Boolean isWorking;
    private String Position;
}
