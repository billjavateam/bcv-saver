package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.CertificateDto
import com.billennium.bcvsaver.entity.Certificate
import com.billennium.bcvsaver.repository.CertificateRepository
import org.springframework.boot.test.context.SpringBootTest
import resources.CommonData
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class CertificateServiceImplSpec extends Specification {
    def certificateRepository = Mock(CertificateRepository)

    @Subject
    def certificateService = new CertificateServiceImpl(certificateRepository)

    def "should create certificate Service"() {
        expect:
        certificateService != null
    }

    def "should add certificates"() {
        given:
        List<CertificateDto> certificateDtoList = CommonData
                .getObjectsFromFactory(CertificateDto.class, new ArrayList<>())
        when:
        List<Certificate> result = certificateService.addCertificates(certificateDtoList)
        List<Certificate> emptyResult = certificateService.addCertificates(null)
        then:
        result.size() == CommonData.times
        CommonData.times * certificateRepository.save(_)
        emptyResult == List.of()
    }
}
