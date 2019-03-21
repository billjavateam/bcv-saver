package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.asm.CvAsm
import com.billennium.bcvsaver.dto.CvDto
import com.billennium.bcvsaver.repository.CvRepository
import com.billennium.bcvsaver.service.CertificateService
import com.billennium.bcvsaver.service.EducationService
import com.billennium.bcvsaver.service.ExperienceService
import com.billennium.bcvsaver.service.LanguageService
import com.billennium.bcvsaver.service.ProjectService
import com.billennium.bcvsaver.service.TechnicalSkillService
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

@SpringBootTest
class CvServiceImplSpec extends Specification {
    def cvRepository = Mock(CvRepository)
    def certificateService = Mock(CertificateService)
    def educationService = Mock(EducationService)
    def languageService = Mock(LanguageService)
    def projectService = Mock(ProjectService)
    def technicalSkillService = Mock(TechnicalSkillService)
    def experienceService = Mock(ExperienceService)

    @Subject
    def cvService = new CvServiceImpl(cvRepository, certificateService, educationService,
            languageService, projectService, technicalSkillService, experienceService)

    PodamFactory factory = new PodamFactoryImpl()

    def "should create cv service"() {
        expect:
        cvService != null
    }

    def "should build cv dependency dto"() {
        given:
        CvDto cvDto = factory.manufacturePojo(CvDto.class)
        certificateService.addCertificates(_) >> List.of()
        educationService.addEducations(_) >> List.of()
        languageService.addLanguages(_) >> List.of()
        projectService.addProjects(_) >> List.of()
        technicalSkillService.addTechnicalSkills(_) >> List.of()
        experienceService.addExperiences(_) >> List.of()
        cvRepository.save(_) >> true
        when:
        def result = cvService.addCv(cvDto)
        then:
        result == cvDto
        1 * cvRepository.save(_)
    }
}
