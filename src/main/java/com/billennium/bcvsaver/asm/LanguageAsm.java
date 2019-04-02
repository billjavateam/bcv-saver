package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.LanguageDto;
import com.billennium.bcvsaver.entity.Language;

import java.util.List;
import java.util.stream.Collectors;

public class LanguageAsm {
    public static Language makeLanguage(LanguageDto languageDto) {
        return Language.builder()
                .name(languageDto.getName())
                .level(languageDto.getLevel())
                .build();
    }

    public static List<Language> makeLanguages(List<LanguageDto> languages) {
        return languages.stream()
                .map(LanguageAsm::makeLanguage)
                .collect(Collectors.toList());
    }
}
