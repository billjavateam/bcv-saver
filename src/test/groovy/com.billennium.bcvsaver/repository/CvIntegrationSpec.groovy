package com.billennium.bcvsaver.repository

import com.billennium.bcvsaver.asm.CvAsm
import com.billennium.bcvsaver.dto.CvDto
import com.billennium.bcvsaver.entity.Cv
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import resources.CommonData
import spock.lang.Specification

@DataJpaTest
class CvIntegrationSpec extends Specification {
    @Autowired
    CvRepository cvRepository

    List<Cv> cv = new ArrayList<>()

    def "should add cv"() {
        given:
        def cvDtoList = CommonData.getObjectsFromFactory(CvDto.class, cv, 300)
        def cvs = CvAsm.makeCvs(cvDtoList)
        when:
        cvRepository.saveAll(cvs)
        def result = cvRepository.findAll()
        then:
        result.size() == CommonData.times
        for (int i = 0; i < CommonData.times; i++) {
            result.get(i).getCertificates() == cvs.get(i).getCertificates()
            result.get(i).getCvLanguage() == cvs.get(i).getCvLanguage()
            result.get(i).getEducations() == cvs.get(i).getEducations()
            result.get(i).getProjects() == cvs.get(i).getProjects()
            result.get(i).getTechnicalSkills() == cvs.get(i).getTechnicalSkills()
            result.get(i).getExperiences() == cvs.get(i).getExperiences()
            result.get(i).getLanguages() == cvs.get(i).getLanguages()

        }
    }
}
