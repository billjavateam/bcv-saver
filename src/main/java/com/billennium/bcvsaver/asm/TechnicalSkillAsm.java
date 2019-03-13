package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.TechnicalSkillDto;
import com.billennium.bcvsaver.entity.TechnicalSkill;

import java.util.List;
import java.util.stream.Collectors;

public class TechnicalSkillAsm {
    public static List<TechnicalSkill> makeTechnicalSkills(List<TechnicalSkillDto> technicalSkills) {
        return technicalSkills.stream()
                .map(technicalSkill -> TechnicalSkill.builder()
                        .expInYears(technicalSkill.getExpInYears())
                        .lvlOfKnowledge(technicalSkill.getLvlOfKnowledge())
                        .build()).collect(Collectors.toList());
    }
}
