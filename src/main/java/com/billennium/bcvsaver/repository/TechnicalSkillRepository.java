package com.billennium.bcvsaver.repository;

import com.billennium.bcvsaver.entity.TechnicalSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalSkillRepository extends JpaRepository<TechnicalSkill, Long> {
}
