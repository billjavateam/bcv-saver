package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.asm.CvAsm;
import com.billennium.bcvsaver.dto.CvDto;
import com.billennium.bcvsaver.entity.Cv;
import com.billennium.bcvsaver.repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CvService {
    private final CvRepository cvRepository;

    @Autowired
    public CvService(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Transactional
    public CvDto addCv(CvDto cvDto) {
        Cv cv = CvAsm.makeCv(cvDto);
        cvRepository.save(cv);
        return cvDto;
    }
}
