package com.billennium.bcvsaver.asm;

import com.billennium.bcvsaver.dto.ProjectDto;
import com.billennium.bcvsaver.entity.Project;

public class ProjectAsm {

    public static Project makeProject(ProjectDto projectDto) {
        return Project.builder()
                .client(projectDto.getClient())
                .position(projectDto.getPosition())
                .build();
    }
}
