package com.billennium.bcvsaver.repository

import com.billennium.bcvsaver.entity.Certificate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import resources.CommonData
import spock.lang.Specification

@DataJpaTest
class CertificateIntegrationSpec extends Specification {
    @Autowired
    private CertificateRepository certificateRepository

    List<Certificate> certificates = new ArrayList<>()

    def "should add certificates"() {
        given:
        List<Certificate> certificates = CommonData.getObjectsFromFactory(Certificate.class, certificates)
        when:
        certificateRepository.saveAll(certificates)
        def result = certificateRepository.findAll()
        then:
        result.size() == CommonData.times
        for (int i = 0; i < CommonData.times; i++) {
            result.get(i).getDate() == certificates.get(i).getDate()
            result.get(i).getName() == certificates.get(i).getName()
        }
    }
}
