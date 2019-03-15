package com.billennium.bcvsaver.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    //@Column(nullable = false)
    private String dateFrom;

    @Basic
    //@Column(nullable = false)
    private String dateTo;

    private Boolean isWorking;

    // it can be other table later
    @Column(nullable = false)
    private String position;
}
