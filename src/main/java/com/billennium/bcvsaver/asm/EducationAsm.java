package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.EducationDto;
import com.billennium.bcvsaver.entity.Education;

import java.util.List;
import java.util.stream.Collectors;

public class EducationAsm {
    public static Education makeEducation(EducationDto educationDto) {
        return Education.builder()
                .dateFrom(educationDto.getDateFrom())
                .dateTo(educationDto.getDateTo())
                .name(educationDto.getName())
                .build();
    }

    public static List<Education> makeEducations(List<EducationDto> educations) {
        return educations.stream()
                .map(EducationAsm::makeEducation)
                .collect(Collectors.toList());
    }
}
