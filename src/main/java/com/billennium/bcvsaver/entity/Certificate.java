package com.billennium.bcvsaver.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "certificate")
@Data
@Builder
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // TODO
    // it should be Date later
    @Basic
    private String date;
}
