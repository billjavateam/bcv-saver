package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.ProjectDto;
import com.billennium.bcvsaver.entity.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectAsm {

    public static Project makeProject(ProjectDto projectDto) {
        return Project.builder()
                .client(projectDto.getClient())
                .position(projectDto.getPosition())
                .build();
    }

    public static List<Project> makeProjects(List<ProjectDto> projects) {
        return projects.stream()
                .map(ProjectAsm::makeProject)
                .collect(Collectors.toList());
    }
}
