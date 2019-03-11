package com.billennium.bcvsaver.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ExperienceDto {
    private Date from;
    private Date to;
    private boolean isWorking;
    private String Position;
}
