package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.TechnicalSkillDto;
import com.billennium.bcvsaver.entity.TechnicalSkill;

public class TechnicalSkillAsm {

    public static TechnicalSkill makeTechnicalSkill(TechnicalSkillDto technicalSkillDto) {
        return TechnicalSkill.builder()
                .expInYears(technicalSkillDto.getExpInYears())
                .lvlOfKnowledge(technicalSkillDto.getLvlOfKnowledge())
                .build();
    }
}
