package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.EducationDto
import com.billennium.bcvsaver.entity.Education
import com.billennium.bcvsaver.repository.EducationRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

@SpringBootTest
class EducationServiceImplSpec extends Specification {
    def educationRepository = Mock(EducationRepository)

    @Subject
    def educationService = new EducationServiceImpl(educationRepository)

    PodamFactory factory = new PodamFactoryImpl()

    def "should create education Service"() {
        expect:
        educationService != null
    }

    def "should add educations"() {
        given:
        Random random = new Random()
        def times = random.nextInt(1000)
        List<EducationDto> educationDtoList = new ArrayList<>()
        for (int i = 0; i < times; i++) {
            educationDtoList.add(null)
            educationDtoList.add(factory.manufacturePojo(EducationDto.class))
        }
        when:
        List<Education> result = educationService.addEducations(educationDtoList)
        List<Education> emptyResult = educationService.addEducations(null)
        then:
        result.size() == times
        times * educationRepository.save(_)
        emptyResult == List.of()
    }
}
