package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.ExperienceDto;
import com.billennium.bcvsaver.entity.Experience;

public class ExperienceAsm {
    public static Experience makeExperience(ExperienceDto experienceDto) {
        return Experience.builder()
                .dateFrom(experienceDto.getDateFrom())
                .dateTo(experienceDto.getDateTo())
                .isWorking(experienceDto.getIsWorking())
                .position(experienceDto.getPosition())
                .build();
    }
}
