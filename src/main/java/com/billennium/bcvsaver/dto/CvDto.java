package com.billennium.bcvsaver.dto;

import lombok.Data;

import java.util.List;

@Data
public class CvDto {
    private String cvLanguage;

    private List<EducationDto> educations;
    private List<ProjectDto> projects;
    private List<TechnicalSkillDto> technicalSkills;
    private List<LanguageDto> languageDtos;
    private List<CertificateDto> certificates;
    private List<ExperienceDto> experiences;
}
