package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.CvDependencyDto;
import com.billennium.bcvsaver.dto.CvDto;
import com.billennium.bcvsaver.entity.Cv;

import java.util.List;

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
}
