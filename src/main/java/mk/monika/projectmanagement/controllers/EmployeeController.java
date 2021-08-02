package mk.monika.projectmanagement.controllers;

import mk.monika.projectmanagement.entities.Employee;
import mk.monika.projectmanagement.repository.IEmployeeRepo;
import mk.monika.projectmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String displayEmployees(Model model) {
        Iterable<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Model model, @Valid Employee employee, Errors errors) {

        if (errors.hasErrors()) {
            return "employees/new-employee";
        }

        employeeService.save(employee);
        return "redirect:/employees/new";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        Employee theEmp = employeeService.findByEmployeeId(id);
        model.addAttribute("employee", theEmp);
        return "employees/new-employee";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        Employee theEmp = employeeService.findByEmployeeId(id);
        employeeService.delete(theEmp);
        return "redirect:/employees";
    }

}
