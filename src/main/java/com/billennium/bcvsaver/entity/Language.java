package com.billennium.bcvsaver.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // it will be enum later
    private String level;

    @ManyToOne
    private Cv cv;

}
