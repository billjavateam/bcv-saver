package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.CvDto;
import com.billennium.bcvsaver.entity.Cv;

public class CvAsm {
    public static Cv makeCv(CvDto cvDto) {
        return Cv.builder()
                .cvLanguage(cvDto.getCvLanguage())
                .educations(EducationAsm.makeEducations(cvDto.getEducations()))
                .technicalSkills(TechnicalSkillAsm.makeTechnicalSkills(cvDto.getTechnicalSkills()))
                .certificates(CertificateAsm.makeCertificates(cvDto.getCertificates()))
                .languages(LanguageAsm.makeLanguages(cvDto.getLanguagesLevel()))
                .projects(ProjectAsm.makeProjects(cvDto.getProjects()))
                .build();
    }
}
