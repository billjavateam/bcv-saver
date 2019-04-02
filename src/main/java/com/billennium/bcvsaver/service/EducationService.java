package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.dto.EducationDto;
import com.billennium.bcvsaver.entity.Education;

import java.util.List;

public interface EducationService {
    List<Education> addEducations(List<EducationDto> educationDtos);
}
