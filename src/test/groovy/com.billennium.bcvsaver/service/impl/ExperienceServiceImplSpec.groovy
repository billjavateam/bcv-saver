package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.ExperienceDto
import com.billennium.bcvsaver.entity.Experience
import com.billennium.bcvsaver.repository.ExperienceRepository
import org.springframework.boot.test.context.SpringBootTest
import resources.CommonData
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class ExperienceServiceImplSpec extends Specification {
    def experienceRepository = Mock(ExperienceRepository)

    @Subject
    def experienceService = new ExperienceServiceImpl(experienceRepository)

    def "should create experience service"() {
        expect:
        experienceService != null
    }

    def "should add experiences"() {
        given:
        List<ExperienceDto> experienceDtoList = CommonData
                .getObjectsFromFactory(ExperienceDto.class, new ArrayList<>())
        when:
        List<Experience> result = experienceService.addExperiences(experienceDtoList)
        List<Experience> emptyResult = experienceService.addExperiences(null)
        then:
        result.size() == CommonData.times
        CommonData.times * experienceRepository.save(_)
        emptyResult == List.of()

    }
}
