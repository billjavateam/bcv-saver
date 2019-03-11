package com.billennium.bcvsaver.dto;

import lombok.Data;

import java.util.List;

@Data
public class CvDto {
    private String cvLanguage;

    private List<EducationDto> educationDtos;
    private List<ProjectDto> projectDtos;
    private List<TechnicalSkillDto> technicalSkillDtos;
    private List<String> languages;
    private List<CertificateDto> certificateDtos;
}
