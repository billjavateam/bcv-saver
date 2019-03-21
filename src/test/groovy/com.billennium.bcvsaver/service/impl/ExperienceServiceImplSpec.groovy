package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.ExperienceDto
import com.billennium.bcvsaver.entity.Experience
import com.billennium.bcvsaver.repository.ExperienceRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

@SpringBootTest
class ExperienceServiceImplSpec extends Specification {
    def experienceRepository = Mock(ExperienceRepository)

    @Subject
    def experienceService = new ExperienceServiceImpl(experienceRepository)

    PodamFactory factory = new PodamFactoryImpl()

    def "should create experience service"() {
        expect:
        experienceService != null
    }

    def "should add experiences"() {
        given:
        Random random = new Random()
        def times = random.nextInt(1000)
        List<ExperienceDto> experienceDtoList = new ArrayList<>()
        for (int i = 0; i < times; i++) {
            experienceDtoList.add(null)
            experienceDtoList.add(factory.manufacturePojo(ExperienceDto.class))
        }
        when:
        List<Experience> result = experienceService.addExperiences(experienceDtoList)
        List<Experience> emptyResult = experienceService.addExperiences(null)
        then:
        result.size() == times
        times * experienceRepository.save(_)
        emptyResult == List.of()

    }
}
