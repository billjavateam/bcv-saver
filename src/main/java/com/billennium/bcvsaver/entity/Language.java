package com.billennium.bcvsaver.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "language")
@Data
@Builder
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // TODO
    // it will be enum later
    private String level;
}
