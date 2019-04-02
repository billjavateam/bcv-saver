package com.billennium.bcvsaver.repository

import com.billennium.bcvsaver.entity.Language
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import resources.CommonData
import spock.lang.Specification

@DataJpaTest
class LanguageIntegrationSpec extends Specification {
    @Autowired
    LanguageRepository languageRepository

    List<Language> languages = new ArrayList<>()

    def "should add languages"() {
        given:
        def languages = CommonData.getObjectsFromFactory(Language.class, languages)
        when:
        languageRepository.saveAll(languages)
        def result = languageRepository.findAll()
        then:
        result.size() == CommonData.times
        for (int i = 0; i < CommonData.times; i++) {
            result.get(i).getLevel() == languages.get(i).getLevel()
            result.get(i).getName() == languages.get(i).getName()
        }
    }
}