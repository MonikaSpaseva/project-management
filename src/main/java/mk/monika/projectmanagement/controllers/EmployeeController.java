package mk.monika.projectmanagement.controllers;

import mk.monika.projectmanagement.entities.Employee;
import mk.monika.projectmanagement.repository.IEmployeeRepo;
import mk.monika.projectmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
//    IEmployeeRepo employeeRepo;
    EmployeeService employeeService;
    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
        public String displayEmployeeForm(Model model){
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        employeeService.save(employee);
        return "redirect:/employees/new";
    }
}