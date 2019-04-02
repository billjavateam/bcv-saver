package com.billennium.bcvsaver.repository;

import com.billennium.bcvsaver.entity.Certificate;
import com.billennium.bcvsaver.entity.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
