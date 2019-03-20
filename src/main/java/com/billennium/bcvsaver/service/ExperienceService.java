package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.asm.ExperienceAsm;
import com.billennium.bcvsaver.dto.ExperienceDto;
import com.billennium.bcvsaver.entity.Experience;
import com.billennium.bcvsaver.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExperienceService {
    private final ExperienceRepository educationRepository;

    @Autowired
    public ExperienceService(ExperienceRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    List<Experience> addExperiences(List<ExperienceDto> educationDtos) {
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
