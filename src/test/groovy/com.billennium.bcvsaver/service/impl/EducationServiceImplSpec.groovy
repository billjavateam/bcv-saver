package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.EducationDto
import com.billennium.bcvsaver.entity.Education
import com.billennium.bcvsaver.repository.EducationRepository
import org.springframework.boot.test.context.SpringBootTest
import resources.CommonData
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class EducationServiceImplSpec extends Specification {
    def educationRepository = Mock(EducationRepository)

    @Subject
    def educationService = new EducationServiceImpl(educationRepository)

    def "should create education Service"() {
        expect:
        educationService != null
    }

    def "should add educations"() {
        given:
        List<EducationDto> educationDtoList = CommonData
                .getObjectsFromFactory(EducationDto.class, new ArrayList<>())
        when:
        List<Education> result = educationService.addEducations(educationDtoList)
        List<Education> emptyResult = educationService.addEducations(null)
        then:
        result.size() == CommonData.times
        CommonData.times * educationRepository.save(_)
        emptyResult == List.of()
    }
}
