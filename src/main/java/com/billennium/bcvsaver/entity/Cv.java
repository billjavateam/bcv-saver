package com.billennium.bcvsaver.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // it could be enum type later
    private String cvLanguage;

    @ManyToOne
    // @Column(nullable = false)
    private User user;

    @OneToMany(mappedBy = "education", cascade = CascadeType.PERSIST)
    private List<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "technicalSkill", cascade = CascadeType.PERSIST)
    private List<TechnicalSkill> technicalSkills = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "language", cascade = CascadeType.PERSIST)
    private List<Language> languages = new ArrayList<>();

    @OneToMany(mappedBy = "certificate", cascade = CascadeType.PERSIST)
    private List<Certificate> certificates = new ArrayList<>();
}
