package com.billennium.bcvsaver.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private Date from;

    @Basic
    @Column(nullable = false)
    private Date to;

    @ManyToOne
    private Cv cv;
}
