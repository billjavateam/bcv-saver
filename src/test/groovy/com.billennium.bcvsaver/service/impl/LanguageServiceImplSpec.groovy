package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.LanguageDto
import com.billennium.bcvsaver.entity.Language
import com.billennium.bcvsaver.repository.LanguageRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

@SpringBootTest
class LanguageServiceImplSpec extends Specification {
    def languageRepository = Mock(LanguageRepository)

    @Subject
    def languageService = new LanguageServiceImpl(languageRepository)

    PodamFactory factory = new PodamFactoryImpl()

    def "should create language service"() {
        expect:
        languageService != null
    }

    def "should add languages"() {
        given:
        Random random = new Random()
        def times = random.nextInt(1000)
        List<LanguageDto> languageDtoList = new ArrayList<>()
        for (int i = 0; i < times; i++) {
            languageDtoList.add(null)
            languageDtoList.add(factory.manufacturePojo(LanguageDto.class))
        }
        when:
        List<Language> result = languageService.addLanguages(languageDtoList)
        List<Language> emptyResult = languageService.addLanguages(null)
        then:
        result.size() == times
        times * languageRepository.save(_)
        emptyResult == List.of()
    }
}
