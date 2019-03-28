package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.ProjectDto
import com.billennium.bcvsaver.entity.Project
import com.billennium.bcvsaver.repository.ProjectRepository
import org.springframework.boot.test.context.SpringBootTest
import resources.CommonData
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class ProjectServiceImplSpec extends Specification {
    def projectRepository = Mock(ProjectRepository)

    @Subject
    def projectService = new ProjectServiceImpl(projectRepository)

    def "should create project service"() {
        expect:
        projectService != null
    }

    def "should add projects"() {
        given:
        List<ProjectDto> projectDtoList = CommonData
                .getObjectsFromFactory(ProjectDto.class, new ArrayList<>())
        when:
        List<Project> result = projectService.addProjects(projectDtoList)
        List<Project> emptyResult = projectService.addProjects(null)
        then:
        result.size() == CommonData.times
        CommonData.times * projectRepository.save(_)
        emptyResult == List.of()
    }
}
