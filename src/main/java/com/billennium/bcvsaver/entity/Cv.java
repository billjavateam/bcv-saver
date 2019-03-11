package com.billennium.bcvsaver.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // it could be enum type later
    private String cvLanguage;

    @ManyToOne
    @Column(nullable = false)
    private User user;

    @OneToMany(mappedBy = "education")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "technicalSkill")
    private List<TechnicalSkill> technicalSkills = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "language")
    private List<Language> languages = new ArrayList<>();

    @OneToMany(mappedBy = "certificate")
    private List<Certificate> certificates = new ArrayList<>();
}
