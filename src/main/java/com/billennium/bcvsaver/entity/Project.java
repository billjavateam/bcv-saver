package com.billennium.bcvsaver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "project")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO
    // could be other table in the future to avoid repeat in database
    @Column(nullable = false)
    private String client;

    // TODO
    // it can be also another table in the future
    @Column(nullable = false)
    private String position;

    @ManyToMany(mappedBy = "projects")
    private Set<Technology> technologies = new HashSet<>();

    // TODO
    // bidiractional relation if needed later
    //@ManyToOne
    //@JoinColumn(name="cv_id")
    //private Cv cv;
}
