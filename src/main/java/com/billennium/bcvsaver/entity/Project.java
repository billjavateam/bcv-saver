package com.billennium.bcvsaver.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // could be other table in the future to avoid repeat in database
    @Column(nullable = false)
    private String client;

    // it can be also another table in the future
    @Column(nullable = false)
    private String position;

    @ManyToMany(mappedBy = "projects")
    private Set<Technology> technologies = new HashSet<>();

    @ManyToOne
    private Cv cv;
}
