package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.EducationDto;
import com.billennium.bcvsaver.entity.Education;

public class EducationAsm {
    public static Education makeEducation(EducationDto educationDto) {
        return Education.builder()
                .dateFrom(educationDto.getDateFrom())
                .dateTo(educationDto.getDateTo())
                .name(educationDto.getName())
                .build();
    }
}
