package com.billennium.bcvsaver.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "cv")
@Data
@Builder
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO
    // it could be enum type later
    private String cvLanguage;

    @ManyToOne
    // @Column(nullable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<TechnicalSkill> technicalSkills = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Language> languages = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Certificate> certificates = new ArrayList<>();
}
