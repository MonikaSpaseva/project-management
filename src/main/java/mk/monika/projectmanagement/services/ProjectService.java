package mk.monika.projectmanagement.services;

import mk.monika.projectmanagement.dto.ProjectStage;
import mk.monika.projectmanagement.entities.Employee;
import mk.monika.projectmanagement.entities.Project;
import mk.monika.projectmanagement.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    IProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public Iterable<Project> getAll(){
        return projectRepository.findAll();
    }

    public List<ProjectStage> getProjectStage() {
        return projectRepository.projectStage();
    }

    public Project findByProjectId(Long id) {

        return projectRepository.findByProjectId(id);
    }

    public void delete(Project theProject) {projectRepository.delete(theProject);
    }
}

