package mk.monika.projectmanagement.repository;

import mk.monika.projectmanagement.Main;
import mk.monika.projectmanagement.entities.Project;
import mk.monika.projectmanagement.repository.IProjectRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

//@ContextConfiguration(classes = Main.class)
@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = {"classpath:drop.sql"})
})
public class ProjectRepoIntegrationTest {
    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void ifNewProjectSavedThenSuccess() {
        Project newProject = new Project("New Test Project", "COMPLETE", "Test Description");
        projectRepository.save(newProject);

        List<Project> projects = StreamSupport.stream(projectRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        assertEquals(5, projects.size());
    }
}
