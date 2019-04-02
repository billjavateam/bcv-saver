package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.TechnicalSkillDto
import com.billennium.bcvsaver.entity.TechnicalSkill
import com.billennium.bcvsaver.repository.TechnicalSkillRepository
import org.springframework.boot.test.context.SpringBootTest
import resources.CommonData
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class TechnicalSkillServiceImplSpec extends Specification {
    def technicalSkillRepository = Mock(TechnicalSkillRepository)

    @Subject
    def technicalSkillService = new TechnicalSkillServiceImpl(technicalSkillRepository)

    def "should create technical skill service"() {
        expect:
        technicalSkillService != null
    }

    def "should add technical skill"() {
        given:
        List<TechnicalSkillDto> technicalSkillDtoList = CommonData
                .getObjectsFromFactory(TechnicalSkillDto.class, new ArrayList<>())
        when:
        List<TechnicalSkill> result = technicalSkillService.addTechnicalSkills(technicalSkillDtoList)
        List<TechnicalSkill> emptyResult = technicalSkillService.addTechnicalSkills(null)
        then:
        result.size() == CommonData.times
        CommonData.times * technicalSkillRepository.save(_)
        emptyResult == List.of()
    }
}
