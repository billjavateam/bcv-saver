package com.billennium.bcvsaver.dto;

import lombok.Data;

@Data
public class ProjectDto {
    private String client;
    private String position;
    // TODO
    // project has many technologies
    //private Set<String> technologies;
}
