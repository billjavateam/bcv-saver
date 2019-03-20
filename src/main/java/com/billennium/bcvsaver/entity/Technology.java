package com.billennium.bcvsaver.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "technology")
@Data
@Builder
public class Technology {
    @Id
    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Technology_Project",
            joinColumns = { @JoinColumn(name = "technology_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private Set<Project> projects;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Technology_TechnicalSkill",
            joinColumns = { @JoinColumn(name = "technology_id") },
            inverseJoinColumns = { @JoinColumn(name = "technical_skill_id") }
    )
    private Set<TechnicalSkill> technicalSkills;
}
