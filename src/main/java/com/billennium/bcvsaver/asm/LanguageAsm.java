package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.LanguageDto;
import com.billennium.bcvsaver.entity.Language;

public class LanguageAsm {
    public static Language makeLanguage(LanguageDto languageDto) {
        return Language.builder()
                .name(languageDto.getName())
                .level(languageDto.getLevel())
                .build();
    }
}
