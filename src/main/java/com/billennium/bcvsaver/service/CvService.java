package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.asm.CvAsm;
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

    @Autowired
    public CvService(CvRepository cvRepository, CertificateService certificateService, EducationService educationService, LanguageService languageService, ProjectService projectService, TechnicalSkillService technicalSkillService) {
        this.cvRepository = cvRepository;
        this.certificateService = certificateService;
        this.educationService = educationService;
        this.languageService = languageService;
        this.projectService = projectService;
        this.technicalSkillService = technicalSkillService;
    }

    @Transactional
    public CvDto addCv(CvDto cvDto) {
        addDependencies(cvDto);
        Cv cv = CvAsm.makeCv(cvDto);
        cvRepository.save(cv);
        return cvDto;
    }

    private void addDependencies(CvDto cvDto) {

    }
}
