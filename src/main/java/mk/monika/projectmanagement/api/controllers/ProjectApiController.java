package mk.monika.projectmanagement.api.controllers;

import mk.monika.projectmanagement.entities.Project;
import mk.monika.projectmanagement.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {

    @Autowired
    IProjectRepository projectRepository;

    @GetMapping
    public Iterable<Project> getProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectId(@PathVariable("id") Long id) {

        Optional<Project> projectById = projectRepository.findById(id);
        return projectById.orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody @Valid Project project) {
        return projectRepository.save(project);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Project update(@RequestBody @Valid Project project) {
        return projectRepository.save(project);
    }

    @PatchMapping(path = "/{id}")
    public Project partialUpdate(@PathVariable("id") Long id, @RequestBody @Valid Project patchProject) {
        Project project = projectRepository.findById(id).get();

        if (patchProject.getName() != null) {
            project.setName(patchProject.getName());
        }

        if (patchProject.getDescription() != null) {
            project.setDescription(patchProject.getDescription());
        }

        if (patchProject.getStage() != null) {
            project.setStage(patchProject.getStage());
        }

        return projectRepository.save(project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        try {
            projectRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
