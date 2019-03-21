package com.billennium.bcvsaver.service.impl;

import com.billennium.bcvsaver.asm.LanguageAsm;
import com.billennium.bcvsaver.dto.LanguageDto;
import com.billennium.bcvsaver.entity.Language;
import com.billennium.bcvsaver.repository.LanguageRepository;
import com.billennium.bcvsaver.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    private Language addLanguage(LanguageDto languageDto) {
        return languageRepository.save(LanguageAsm.makeLanguage(languageDto));
    }

    public List<Language> addLanguages(List<LanguageDto> languageDtos) {
        return Optional.ofNullable(languageDtos).orElse(List.of())
                .stream()
                .filter(Objects::nonNull)
                .map(this::addLanguage)
                .collect(Collectors.toList());
    }
}
