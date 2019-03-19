package com.billennium.bcvsaver.dto;

import com.billennium.bcvsaver.entity.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CvDependencyDto {
    private List<Education> educations = new ArrayList<>();
    private List<TechnicalSkill> technicalSkills = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<Language> languages = new ArrayList<>();
    private List<Certificate> certificates = new ArrayList<>();
}
