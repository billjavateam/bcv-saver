package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.EducationDto;
import com.billennium.bcvsaver.entity.Education;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class EducationAsm {
    public static List<Education> makeEducations(List<EducationDto> educations) {
        return Optional.ofNullable(educations).orElse(List.of())
                .stream()
                .filter(Objects::nonNull)
                .map(educationDto -> Education.builder()
                .name(educationDto.getName())
                .dateFrom(educationDto.getFrom())
                .dateTo(educationDto.getTo())
                .build()).collect(Collectors.toList());
    }
}
