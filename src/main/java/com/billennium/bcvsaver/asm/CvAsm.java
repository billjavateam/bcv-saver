package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.CvDependencyDto;
import com.billennium.bcvsaver.dto.CvDto;
import com.billennium.bcvsaver.dto.LanguageDto;
import com.billennium.bcvsaver.entity.Cv;

import java.util.List;
import java.util.stream.Collectors;

public class CvAsm {
    public static Cv makeCv(CvDto cvDto, CvDependencyDto cvDependency) {
        return Cv.builder()
                .cvLanguage(cvDto.getCvLanguage())
                .educations(cvDependency.getEducations())
                .technicalSkills(cvDependency.getTechnicalSkills())
                .certificates(cvDependency.getCertificates())
                .languages(cvDependency.getLanguages())
                .projects(cvDependency.getProjects())
                .build();
    }

    private static Cv makeCvFromDto(CvDto cvDto) {
        return Cv.builder()
                .cvLanguage(cvDto.getCvLanguage())
                .educations(EducationAsm.makeEducations(cvDto.getEducations()))
                .technicalSkills(TechnicalSkillAsm.makeTechnicalSkills(cvDto.getTechnicalSkills()))
                .certificates(CertificateAsm.makeCertificates(cvDto.getCertificates()))
                .languages(LanguageAsm.makeLanguages(cvDto.getLanguages()))
                .projects(ProjectAsm.makeProjects(cvDto.getProjects()))
                .build();
    }

    public static List<Cv> makeCvs(List<CvDto> cvDtoList) {
        return cvDtoList.stream().map(CvAsm::makeCvFromDto).collect(Collectors.toList());
    }
}
