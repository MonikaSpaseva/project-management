package mk.monika.projectmanagement.controllers;

import mk.monika.projectmanagement.entities.Employee;
import mk.monika.projectmanagement.entities.Project;
import mk.monika.projectmanagement.repository.IEmployeeRepo;
import mk.monika.projectmanagement.repository.IProjectRepository;
import mk.monika.projectmanagement.services.EmployeeService;
import mk.monika.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
//    IProjectRepository projectRepository;
     ProjectService projectService;
    @Autowired
//    IEmployeeRepo employeeRepo;
    EmployeeService employeeService;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();

        List<Employee> employees = employeeService.getAll();

        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        // this should handle saving to the database...
        projectService.save(project);

        //  Iterable<Employee>chosenEmployees = employeeRepo.findAllById(employees);

//        for (Employee employee : chosenEmployees) {
//            employee.setProjects(project);
//            employeeRepo.save(employee);
//        }

        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }
}
