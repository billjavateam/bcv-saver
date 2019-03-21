package com.billennium.bcvsaver.service.impl

import com.billennium.bcvsaver.dto.ProjectDto
import com.billennium.bcvsaver.entity.Project
import com.billennium.bcvsaver.repository.ProjectRepository
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

@SpringBootTest
class ProjectServiceImplSpec extends Specification {
    def projectRepository = Mock(ProjectRepository)

    @Subject
    def projectService = new ProjectServiceImpl(projectRepository)

    PodamFactory factory = new PodamFactoryImpl()

    def "should create project service"() {
        expect:
        projectService != null
    }

    def "should add projects"() {
        given:
        Random random = new Random()
        def times = random.nextInt(1000)
        List<ProjectDto> projectDtoList = new ArrayList<>()
        for (int i = 0; i < times; i++) {
            projectDtoList.add(null)
            projectDtoList.add(factory.manufacturePojo(ProjectDto.class))
        }
        when:
        List<Project> result = projectService.addProjects(projectDtoList)
        List<Project> emptyResult = projectService.addProjects(null)
        then:
        result.size() == times
        times * projectRepository.save(_)
        emptyResult == List.of()
    }
}
