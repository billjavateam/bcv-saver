package com.billennium.bcvsaver.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "experience")
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO
    // it should be Date later
    @Basic
    //@Column(nullable = false)
    private String dateFrom;

    // TODO
    // it should be Date later
    @Basic
    //@Column(nullable = false)
    private String dateTo;

    private Boolean isWorking;

    // TODO
    // it can be other table later
    @Column(nullable = false)
    private String position;
}
