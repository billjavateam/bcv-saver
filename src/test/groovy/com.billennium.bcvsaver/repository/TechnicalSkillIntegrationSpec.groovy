package com.billennium.bcvsaver.repository

import com.billennium.bcvsaver.asm.TechnicalSkillAsm
import com.billennium.bcvsaver.dto.TechnicalSkillDto
import com.billennium.bcvsaver.entity.TechnicalSkill
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import resources.CommonData
import spock.lang.Specification

@DataJpaTest
class TechnicalSkillIntegrationSpec extends Specification {
    @Autowired
    TechnicalSkillRepository technicalSkillRepository

    List<TechnicalSkill> technicalSkills = new ArrayList<>()

    def "should add technical skill"() {
        given:
        def technicalSkillDtoList = CommonData.getObjectsFromFactory(TechnicalSkillDto.class, technicalSkills)
        def technicalSkills = TechnicalSkillAsm.makeTechnicalSkills(technicalSkillDtoList)
        when:
        technicalSkillRepository.saveAll(technicalSkills)
        def result = technicalSkillRepository.findAll()
        then:
        result.size() == CommonData.times
        for (int i = 0; i < CommonData.times; i++) {
            result.get(i).getExpInYears() == technicalSkills.get(i).getExpInYears()
            result.get(i).getLvlOfKnowledge() == technicalSkills.get(i).getLvlOfKnowledge()
        }
    }
}
