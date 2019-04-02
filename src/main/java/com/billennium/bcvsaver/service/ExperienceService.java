package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.dto.ExperienceDto;
import com.billennium.bcvsaver.entity.Experience;

import java.util.List;

public interface ExperienceService {
    List<Experience> addExperiences(List<ExperienceDto> educationDtos);
}
