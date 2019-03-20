package com.billennium.bcvsaver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Data
public class User {
    @Id
    private String eMail;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Cv> cvs = new ArrayList<>();
}
