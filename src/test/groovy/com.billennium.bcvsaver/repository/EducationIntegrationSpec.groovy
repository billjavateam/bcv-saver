package com.billennium.bcvsaver.repository

import com.billennium.bcvsaver.entity.Education
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import resources.CommonData
import spock.lang.Specification

@DataJpaTest
class EducationIntegrationSpec extends Specification {
    @Autowired
    EducationRepository educationRepository

    List<Education> educations = new ArrayList<>()

    def "should add educations"() {
        given:
        def educations = CommonData.getObjectsFromFactory(Education.class, educations)
        when:
        educationRepository.saveAll(educations)
        def result = educationRepository.findAll()
        then:
        result.size() == CommonData.times
        for (int i = 0; i < CommonData.times; i++) {
            result.get(i).getDateFrom() == educations.get(i).getDateFrom()
            result.get(i).getDateTo() == educations.get(i).getDateTo()
            result.get(i).getName() == educations.get(i).getName()
        }
    }
}
