package com.billennium.bcvsaver.service.impl;

import com.billennium.bcvsaver.asm.TechnicalSkillAsm;
import com.billennium.bcvsaver.dto.TechnicalSkillDto;
import com.billennium.bcvsaver.entity.TechnicalSkill;
import com.billennium.bcvsaver.repository.TechnicalSkillRepository;
import com.billennium.bcvsaver.service.TechnicalSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TechnicalSkillServiceImpl implements TechnicalSkillService {
    private final TechnicalSkillRepository technicalSkillRepository;

    @Autowired
    public TechnicalSkillServiceImpl(TechnicalSkillRepository technicalSkillRepository) {
        this.technicalSkillRepository = technicalSkillRepository;
    }

    public List<TechnicalSkill> addTechnicalSkills(List<TechnicalSkillDto> technicalSkillDtos) {
        return Optional.ofNullable(technicalSkillDtos).orElse(List.of())
                .stream()
                .filter(Objects::nonNull)
                .map(this::addTechnicalSkill)
                .collect(Collectors.toList());
    }

    private TechnicalSkill addTechnicalSkill(TechnicalSkillDto technicalSkillDto) {
        return technicalSkillRepository.save(TechnicalSkillAsm.makeTechnicalSkill(technicalSkillDto));
    }
}
