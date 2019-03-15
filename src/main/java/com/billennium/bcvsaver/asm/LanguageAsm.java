package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.entity.Language;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class LanguageAsm {
    public static List<Language> makeLanguages(List<String> languagesLevel) {
        return Optional.ofNullable(languagesLevel).orElse(List.of())
                .stream()
                .filter(Objects::nonNull)
                .map(languageLevel -> Language.builder()
                        .level(languageLevel)
                        .build()).collect(Collectors.toList());
    }
}
