package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.repository.TechnicalSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicalSkillService {
    public final TechnicalSkillRepository technicalSkillRepository;

    @Autowired
    public TechnicalSkillService(TechnicalSkillRepository technicalSkillRepository) {
        this.technicalSkillRepository = technicalSkillRepository;
    }
}
