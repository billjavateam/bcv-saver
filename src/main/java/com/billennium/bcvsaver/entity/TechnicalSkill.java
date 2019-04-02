package com.billennium.bcvsaver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "technical_skill")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnicalSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "technicalSkills")
    private Set<Technology> technologies = new HashSet<>();

    // TODO
    // it can be values like 1.5
    private Double expInYears;

    // TODO
    // it will be enum 1-5
    private Integer lvlOfKnowledge;
}
