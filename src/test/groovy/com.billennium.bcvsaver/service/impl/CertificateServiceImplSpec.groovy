package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.CertificateDto
import com.billennium.bcvsaver.entity.Certificate
import com.billennium.bcvsaver.repository.CertificateRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

@SpringBootTest
class CertificateServiceImplSpec extends Specification {
    def certificateRepository = Mock(CertificateRepository)

    @Subject
    def certificateService = new CertificateServiceImpl(certificateRepository)

    PodamFactory factory = new PodamFactoryImpl()

    def "should create certificate Service"() {
        expect:
        certificateService != null
    }

    def "should add certificates"() {
        given:
        Random random = new Random()
        def times = random.nextInt(1000)
        List<CertificateDto> certificateDtoList = new ArrayList<>()
        for (int i = 0; i < times; i++) {
            certificateDtoList.add(null)
            certificateDtoList.add(factory.manufacturePojo(CertificateDto.class))
        }
        when:
        List<Certificate> result = certificateService.addCertificates(certificateDtoList)
        List<Certificate> emptyResult = certificateService.addCertificates(null)
        then:
        result.size() == times
        times * certificateRepository.save(_)
        emptyResult == List.of()
    }
}
