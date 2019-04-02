package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.dto.TechnicalSkillDto;
import com.billennium.bcvsaver.entity.TechnicalSkill;

import java.util.List;

public interface TechnicalSkillService {
    List<TechnicalSkill> addTechnicalSkills(List<TechnicalSkillDto> technicalSkillDtos);
}
