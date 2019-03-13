package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.EducationDto;
import com.billennium.bcvsaver.entity.Education;

import java.util.List;
import java.util.stream.Collectors;

public class EducationAsm {
    public static List<Education> makeEducations(List<EducationDto> educations) {
        return educations.stream()
                .map(educationDto -> Education.builder()
                .name(educationDto.getName())
                .from(educationDto.getFrom())
                .to(educationDto.getTo())
                .build()).collect(Collectors.toList());
    }
}
