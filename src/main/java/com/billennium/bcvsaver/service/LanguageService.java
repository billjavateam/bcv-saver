package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.dto.LanguageDto;
import com.billennium.bcvsaver.entity.Language;

import java.util.List;

public interface LanguageService {
    List<Language> addLanguages(List<LanguageDto> languageDtos);
}
