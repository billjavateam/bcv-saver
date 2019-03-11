package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.dto.CvDto;
import com.billennium.bcvsaver.repository.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvService {
    private final CvRepository cvRepository;

    @Autowired
    public CvService(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }


    public CvDto addCv(CvDto cvDto) {
        return cvDto;
    }
}
