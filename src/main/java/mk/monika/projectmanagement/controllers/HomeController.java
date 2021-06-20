package mk.monika.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.monika.projectmanagement.dto.EmployeeProject;
import mk.monika.projectmanagement.dto.ProjectStage;
import mk.monika.projectmanagement.entities.Project;
import mk.monika.projectmanagement.repository.IEmployeeRepo;
import mk.monika.projectmanagement.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    IProjectRepository projectRepository;
    @Autowired
    IEmployeeRepo employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();


        List<Project> projectList = projectRepository.findAll();
        List<EmployeeProject> employeesProjectCount = employeeRepo.employeeProjects();
        model.addAttribute("projectList", projectList);
        model.addAttribute("employeesListProjectsCount", employeesProjectCount);

        List<ProjectStage> projectData = projectRepository.projectStage();

        // convert project data object into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);

        model.addAttribute("projectStatusCount", jsonString);
        return "home/home";
    }
}
