package com.billennium.bcvsaver.service

import com.billennium.bcvsaver.repository.CvRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class CvServiceSpec extends Specification {
    def cvRepository = Mock(CvRepository)
    def certificateService = Mock(CertificateService)
    def educationService = Mock(EducationService)
    def languageService = Mock(LanguageService)
    def projectService = Mock(ProjectService)
    def technicalSkillService = Mock(TechnicalSkillService)

    def "should create cv service"() {
        when:
        def cvService = new CvService(cvRepository, certificateService, educationService,
                languageService, projectService, technicalSkillService)
        then:
        cvService != null
    }
}
