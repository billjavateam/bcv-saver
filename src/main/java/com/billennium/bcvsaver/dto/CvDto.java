package com.billennium.bcvsaver.dto;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class CvDto {
    private String cvLanguage;

    private List<EducationDto> educations;
    private List<ProjectDto> projects;
    private List<TechnicalSkillDto> technicalSkills;
    private List<String> languagesLevel;
    private List<CertificateDto> certificates;
}
