package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.TechnicalSkillDto;
import com.billennium.bcvsaver.entity.TechnicalSkill;

import java.util.List;
import java.util.stream.Collectors;

public class TechnicalSkillAsm {

    public static TechnicalSkill makeTechnicalSkill(TechnicalSkillDto technicalSkillDto) {
        return TechnicalSkill.builder()
                .expInYears(technicalSkillDto.getExpInYears())
                .lvlOfKnowledge(technicalSkillDto.getLvlOfKnowledge())
                .build();
    }

    public static List<TechnicalSkill> makeTechnicalSkills(List<TechnicalSkillDto> technicalSkillDtoList) {
        return technicalSkillDtoList.stream()
                .map(TechnicalSkillAsm::makeTechnicalSkill)
                .collect(Collectors.toList());
    }
}
