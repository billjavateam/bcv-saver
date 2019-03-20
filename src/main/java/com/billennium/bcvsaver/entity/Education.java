package com.billennium.bcvsaver.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "education")
@Data
@Builder
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

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
}
