package com.billennium.bcvsaver.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ProjectDto {
    private String client;
    private String position;
    private Set<String> technologies;
}
