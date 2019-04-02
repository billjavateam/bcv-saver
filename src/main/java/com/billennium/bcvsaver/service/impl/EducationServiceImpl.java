package com.billennium.bcvsaver.service.impl;

import com.billennium.bcvsaver.asm.EducationAsm;
import com.billennium.bcvsaver.dto.EducationDto;
import com.billennium.bcvsaver.entity.Education;
import com.billennium.bcvsaver.repository.EducationRepository;
import com.billennium.bcvsaver.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }


    public List<Education> addEducations(List<EducationDto> educationDtos) {
        return Optional.ofNullable(educationDtos).orElse(List.of())
                .stream()
                .filter(Objects::nonNull)
                .map(this::addEducation)
                .collect(Collectors.toList());
    }

    private Education addEducation(EducationDto educationDto) {
        return educationRepository.save(EducationAsm.makeEducation(educationDto));
    }
}
