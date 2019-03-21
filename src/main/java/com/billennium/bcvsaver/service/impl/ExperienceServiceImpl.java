package com.billennium.bcvsaver.service.impl;

import com.billennium.bcvsaver.asm.ExperienceAsm;
import com.billennium.bcvsaver.dto.ExperienceDto;
import com.billennium.bcvsaver.entity.Experience;
import com.billennium.bcvsaver.repository.ExperienceRepository;
import com.billennium.bcvsaver.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository educationRepository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<Experience> addExperiences(List<ExperienceDto> educationDtos) {
        return Optional.ofNullable(educationDtos).orElse(List.of())
                .stream()
                .filter(Objects::nonNull)
                .map(this::addExperience)
                .collect(Collectors.toList());
    }

    private Experience addExperience(ExperienceDto educationDto) {
        return educationRepository.save(ExperienceAsm.makeExperience(educationDto));
    }
}
