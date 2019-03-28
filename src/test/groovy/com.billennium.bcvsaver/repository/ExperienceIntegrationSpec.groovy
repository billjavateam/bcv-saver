package com.billennium.bcvsaver.repository

import com.billennium.bcvsaver.entity.Experience
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import resources.CommonData
import spock.lang.Specification

@DataJpaTest
class ExperienceIntegrationSpec extends Specification {
    @Autowired
    ExperienceRepository experienceRepository

    List<Experience> experiences = new ArrayList<>()

    def "should add experiences"() {
        given:
        def experiences = CommonData.getObjectsFromFactory(Experience.class, experiences)
        when:
        experienceRepository.saveAll(experiences)
        def result = experienceRepository.findAll()
        then:
        result.size() == CommonData.times
        for (int i = 0; i < CommonData.times; i++) {
            result.get(i).getIsWorking() == experiences.get(i).getIsWorking()
            result.get(i).getDateTo() == experiences.get(i).getDateTo()
            result.get(i).getDateFrom() == experiences.get(i).getDateFrom()
            result.get(i).getPosition() == experiences.get(i).getPosition()
        }
    }
}
