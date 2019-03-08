package com.billennium.bcvsaver.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class TechnicalSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "technicalSkills")
    private Set<Technology> technologies = new HashSet<>();

    // it can be values like 1.5
    private Float expInYears;

    // it will be enum 1-5
    private int lvlOfKnowledge;
}
