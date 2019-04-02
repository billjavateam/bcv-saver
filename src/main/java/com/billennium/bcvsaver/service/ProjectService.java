package com.billennium.bcvsaver.service;

import com.billennium.bcvsaver.dto.ProjectDto;
import com.billennium.bcvsaver.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> addProjects(List<ProjectDto> projectDtos);
}
