package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.asm.CvAsm;
import com.billennium.bcvsaver.dto.CvDependencyDto;
import com.billennium.bcvsaver.dto.CvDto;
import com.billennium.bcvsaver.entity.Cv;
import com.billennium.bcvsaver.repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CvService {
    private final CvRepository cvRepository;
    private final CertificateService certificateService;
    private final EducationService educationService;
    private final LanguageService languageService;
    private final ProjectService projectService;
    private final TechnicalSkillService technicalSkillService;
    private final ExperienceService experienceService;

    @Autowired
    public CvService(CvRepository cvRepository, CertificateService certificateService,
                     EducationService educationService, LanguageService languageService, ProjectService projectService,
                     TechnicalSkillService technicalSkillService, ExperienceService experienceService) {
        this.cvRepository = cvRepository;
        this.certificateService = certificateService;
        this.educationService = educationService;
        this.languageService = languageService;
        this.projectService = projectService;
        this.technicalSkillService = technicalSkillService;
        this.experienceService = experienceService;
    }

    @Transactional
    public CvDto addCv(CvDto cvDto) {
        Cv cv = CvAsm.makeCv(cvDto, addDependencies(cvDto));
        cvRepository.save(cv);
        return cvDto;
    }

    private CvDependencyDto addDependencies(CvDto cvDto) {
        return CvDependencyDto.builder()
                .certificates(certificateService.addCertificates(cvDto.getCertificates()))
                .educations(educationService.addEducations(cvDto.getEducations()))
                .languages(languageService.addLanguages(cvDto.getLanguageDtos()))
                .projects(projectService.addProjects(cvDto.getProjects()))
                .technicalSkills(technicalSkillService.addTechnicalSkills(cvDto.getTechnicalSkills()))
                .experiences(experienceService.addExperiences(cvDto.getExperiences()))
                .build();
    }
}
