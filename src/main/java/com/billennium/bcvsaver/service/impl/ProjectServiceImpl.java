package com.billennium.bcvsaver.service.impl;

import com.billennium.bcvsaver.asm.ProjectAsm;
import com.billennium.bcvsaver.dto.ProjectDto;
import com.billennium.bcvsaver.entity.Project;
import com.billennium.bcvsaver.repository.ProjectRepository;
import com.billennium.bcvsaver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> addProjects(List<ProjectDto> projectDtos) {
        return Optional.ofNullable(projectDtos).orElse(List.of())
                .stream()
                .filter(Objects::nonNull)
                .map(this::addProject)
                .collect(Collectors.toList());
    }

    private Project addProject(ProjectDto projectDto) {
        return projectRepository.save(ProjectAsm.makeProject(projectDto));
    }
}
