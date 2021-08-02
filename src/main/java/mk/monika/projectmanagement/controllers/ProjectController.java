package mk.monika.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.monika.projectmanagement.dto.TimeChartData;
import mk.monika.projectmanagement.entities.Employee;
import mk.monika.projectmanagement.entities.Project;
import mk.monika.projectmanagement.repository.IEmployeeRepo;
import mk.monika.projectmanagement.repository.IProjectRepository;
import mk.monika.projectmanagement.services.EmployeeService;
import mk.monika.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String displayProjects(Model model) {
        Iterable<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();

        Iterable<Employee> employees = employeeService.getAll();

        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model, @Valid Project project, Errors errors) {
        if (errors.hasErrors()) {
            Iterable<Employee> employees = employeeService.getAll();
            model.addAttribute("project", project);
            model.addAttribute("allEmployees", employees);

            return "projects/new-project";
        }
        projectService.save(project);

        return "redirect:/projects";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Project theProject = projectService.findByProjectId(id);
        model.addAttribute("project", theProject);
        return "projects/new-project";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        Project theProject = projectService.findByProjectId(id);
        projectService.delete(theProject);
        return "redirect:/projects";
    }

    @GetMapping("/timelines")
    public String displayProjectTimelines(Model model) throws JsonProcessingException {

        List<TimeChartData> timelineData = projectService.getTimeData();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTimelineString = objectMapper.writeValueAsString(timelineData);

        System.out.println(jsonTimelineString);

        model.addAttribute("projectTimeList", jsonTimelineString);
        return "projects/project-timelines";
    }
}
