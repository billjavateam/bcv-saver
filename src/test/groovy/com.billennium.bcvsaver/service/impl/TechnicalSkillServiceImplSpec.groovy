package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.TechnicalSkillDto
import com.billennium.bcvsaver.entity.TechnicalSkill
import com.billennium.bcvsaver.repository.TechnicalSkillRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

@SpringBootTest
class TechnicalSkillServiceImplSpec extends Specification {
    def technicalSkillRepository = Mock(TechnicalSkillRepository)

    @Subject
    def technicalSkillService = new TechnicalSkillServiceImpl(technicalSkillRepository)

    PodamFactory factory = new PodamFactoryImpl()

    def "should create technical skill service"() {
        expect:
        technicalSkillService != null
    }

    def "should add technical skill"() {
        given:
        Random random = new Random()
        def times = random.nextInt(1000)
        List<TechnicalSkillDto> technicalSkillDtoList = new ArrayList<>()
        for (int i = 0; i < times; i++) {
            technicalSkillDtoList.add(null)
            technicalSkillDtoList.add(factory.manufacturePojo(TechnicalSkillDto.class))
        }
        when:
        List<TechnicalSkill> result = technicalSkillService.addTechnicalSkills(technicalSkillDtoList)
        List<TechnicalSkill> emptyResult = technicalSkillService.addTechnicalSkills(null)
        then:
        result.size() == times
        times * technicalSkillRepository.save(_)
        emptyResult == List.of()
    }
}
