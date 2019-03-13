package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.ProjectDto;
import com.billennium.bcvsaver.entity.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectAsm {
    public static List<Project> makeProjects(List<ProjectDto> projects) {
        return projects.stream()
                .map(project -> Project.builder()
                        .client(project.getClient())
                        .position(project.getPosition())
                        .build()).collect(Collectors.toList());
    }
}
