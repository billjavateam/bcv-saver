package com.billennium.bcvsaver.repository

import com.billennium.bcvsaver.dto.ProjectDto
import com.billennium.bcvsaver.entity.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import resources.CommonData
import spock.lang.Specification

import static com.billennium.bcvsaver.asm.ProjectAsm.*

@DataJpaTest
class ProjectIntegrationSpec extends Specification {
    @Autowired
    ProjectRepository projectRepository

    List<Project> projects = new ArrayList<>()

    def "should add projects"() {
        given:
        def projectDtoList = CommonData.getObjectsFromFactory(ProjectDto.class, projects)
        def projects = makeProjects(projectDtoList)
        when:
        projectRepository.saveAll(projects)
        def result = projectRepository.findAll()
        then:
        result.size() == CommonData.times
        for (int i = 0; i < CommonData.times; i++) {
            result.get(i).getClient() == projects.get(i).getClient()
            result.get(i).getPosition() == projects.get(i).getPosition()

        }
    }
}
