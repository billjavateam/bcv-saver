package com.billennium.bcvsaver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "experience")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private Date dateFrom;

    @Basic
    private Date dateTo;

    private Boolean isWorking;

    // TODO
    // it can be other table later
    @Column(nullable = false)
    private String position;
}
